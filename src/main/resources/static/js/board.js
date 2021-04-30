
let index = {
    init:function(){
        $("#btn-save").on("click", ()=>{ // jQuery사용 , function(){}, ()=>{} this를 바인딩딩하기 위해서!!
            this.save();  // save 함수가 호출됨
       });

        $("#btn-delete").on("click", ()=> {
            this.deleteById();
        });

        $("#btn-update").on("click", ()=> {
            this.update();
        });
        $("#btn-reply-save").on("click", ()=> {
            this.replySave();
        });
    },

    save: function(){
        let data = {
                title: $("#title").val(),
                content: $("#content").val()
         }

            $.ajax({
                type: "POST",
                url: "/api/board",
                data:JSON.stringify(data), // http body 데이터
                contentType: "application/json; charset=utf-8",
                dataType:"json" //
            }).done(function(resp){
               alert("글쓰기가 완료되었습니다.");
               location.href = "/";
            }).fail(function(error){
                alert(JSON.stringify(error));
            });
          },

        deleteById: function(){
            let id = $("#id").text(); // 아이디값을 찾아서

            $.ajax({
                type: "DELETE",
                url: "/api/board/" +id,
                dataType:"json",
                contentType: "application/json; charset=utf-8"

            }).done(function(resp){
                alert("삭제가 완료되었습니다.");
                location.href = "/";
            }).fail(function(error){
                alert(JSON.stringify(error));
            });
        },

        update: function(){
            let id = $("#id").val();

            let data = {
                title: $("#title").val(),
                content: $("#content").val()
            };

            $.ajax({
                type: "PUT",
                url: "/api/board/"+id,
                data:JSON.stringify(data), // http body 데이터
                contentType: "application/json; charset=utf-8",
                dataType:"json"
            }).done(function(resp){
                alert("글 수정이 완료되었습니다.");
                location.href = "/";
            }).fail(function(error){
                alert(JSON.stringify(error));
            });
        },

    replySave: function(){
        let data = {
            content: $("#reply-content").val()
        };
        let boardId = $("#boardId").val();


        $.ajax({
            type: "POST",
            url: `/api/board/${boardId}/reply`,
            data:JSON.stringify(data), // http body 데이터
            contentType: "application/json; charset=utf-8",
            dataType:"json" //
        }).done(function(resp){
            alert("댓글작성이 완료되었습니다.");
            location.href = `/board/${boardId}`;
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },
}
index.init();
