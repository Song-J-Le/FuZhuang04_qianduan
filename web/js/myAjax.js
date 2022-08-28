

function myAjax(url, data, type) {
    let result = null;
    //ajax默认异步请求
    $.ajax({
        url: url,//访问后台servlet层的地址
        data: data,
        async: false,//关掉异步请求
        type: type,//对于后台的方法
        dataType: 'json',//固定以json对象进行传递
        success: function (res) {//只要后台返回成功，才能进行当前方法，res表示后台返回的值
            console.log(res);
            result = res;
        }
    });
    return result;
}