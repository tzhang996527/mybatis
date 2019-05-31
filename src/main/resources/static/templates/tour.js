//var axios = require('./js/axios.min');
//https://www.kancloud.cn/yunye/axios/234845
var app =
new Vue({
          el: '#app',
          data: function() {
            return { visible: false,
            items : [],
            message: "test"}
          },
          methods: {
              test (){
                axios.get('/api/v1/tour')
                  .then((response) => {
                    this.items = response.data;
                    this.message = "Data received";
                    console.log(response);
                  })
                  .catch(function (error) {
                    console.log(error);
                  });
              },
              login () {
//                  axios.defaults.baseURL = 'http://localhost:8443/'
                  axios.post('/apis/login', {
                    loginName: this.loginInfoVo.username,
                    password: this.loginInfoVo.password
                  })
                  .then(successResponse => {
                    this.responseResult = JSON.stringify(successResponse.data)
                    if (successResponse.data.code === 200) {
                      this.$router.replace({path: '/index'})
                    }
                  })
                  .catch(failResponse => {})
              }
            }

});