<<<<<<< HEAD
// let index = {
//     init:function(){
//         $("#btn-save").on("click", ()=>{ // jQuery사용 , function(){}, ()=>{} this를 바인딩딩하기 위해서!!
//             this.save();  // save 함수가 호출됨
//         }); //JQuery
//     },
//
//     save: function(){
//         let data = {
//             title: $("#title").val(),
//             content: $("#content").val()
//         }
//
//         $.ajax({
//             type: "POST",
//             url: "/api/board/",
//             data:JSON.stringify(data),
//             contentType: "application/json; charset=utf-8",
//             dataType:"json" //
//         }).done(function(resp){
//             alert("글쓰기가 완료되었습니다.");
//             location.href = "/";
//         }).fail(function(error){
//             alert(JSON.stringify(error));
//         });
//     }
// }
// index.init();
=======
let index = {
    init:function(){
        $("#btn-save").on("click", ()=>{ // jQuery사용 , function(){}, ()=>{} this를 바인딩딩하기 위해서!!
            this.save();  // save 함수가 호출됨
       }); //JQuery
    },

    save: function(){
        let data = {
                title: $("#title").val(),
                content: $("#content").val()
         }

            $.ajax({
                type: "POST",
                url: "/api/board/",
                data:JSON.stringify(data),
                contentType: "application/json; charset=utf-8",
                dataType:"json" //
            }).done(function(resp){
               alert("글쓰기가 완료되었습니다.");
               location.href = "/";
            }).fail(function(error){
                alert(JSON.stringify(error));
            });
    }
}
index.init();
>>>>>>> 6a98001402c69fa11a917eead30b2635cf8cc5e2