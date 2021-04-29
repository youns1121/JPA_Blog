let index = {
    init:function(){
        $("#btn-save").on("click", ()=>{ // jQuery사용 , function(){}, ()=>{} this를 바인딩딩하기 위해서!!
            this.save();  // save 함수가 호출됨
       }); //JQuery

        $("#btn-update").on("click", ()=>{ // jQuery사용 , function(){}, ()=>{} this를 바인딩딩하기 위해서!!
            this.update();  // save 함수가 호출됨
        }); //JQuery
    },

    save: function(){
        // alert("user의 save함수 호출됨");
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()
        }

        // console.log(data); // 자바스크립트 오브젝트
        // console.log(JSON.stringify((data)); //JSON 문자열

//        console.log(data);

        // ajax호출시 default가 비동기 호출
        // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청!!
        // ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트로 변환해줌
        $.ajax({
            type: "POST",
            url: "/auth/joinProc",
            data:JSON.stringify(data), //http body데이터
            contentType: "application/json; charset=utf-8", //body데이터가 어떤 타입인지(MIME)
            dataType:"json" // 요청을 서버로해서 응답이 왔을 떄 기본적으로 모든 것이 문자열 (생긴게 json이라면) => javascript오브젝트로
        }).done(function(resp){
            alert("회원가입이 완료되었습니다.");
            // console.log(resp);
            location.href = "/";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });

    },

    update: function(){
        // alert("user의 save함수 호출됨");
        let data = {
                id: $("#id").val(),
                username: $("#username").val(),
                password: $("#password").val(),
                email: $("#email").val()
         }

            // ajax호출시 default가 비동기 호출
            // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청!!
            // ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트로 변환해줌
            $.ajax({
                type: "PUT",
                url: "/user",
                data:JSON.stringify(data), //http body데이터
                contentType: "application/json; charset=utf-8", //body데이터가 어떤 타입인지(MIME)
                dataType:"json" // 요청을 서버로해서 응답이 왔을 떄 기본적으로 모든 것이 문자열 (생긴게 json이라면) => javascript오브젝트로
            }).done(function(resp){
               alert("회원수정이 완료되었습니다.");
               // console.log(resp);
               location.href = "/";
            }).fail(function(error){
                alert(JSON.stringify(error));
            });
    },
}
index.init();