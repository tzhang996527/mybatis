let Home = { template:'<h1>this is home</h1>'};

let About = { template:'<h1>this is ABout</h1>'};

let routes = [
{ path: '/', component: Home },
{ path: '/about', component: About }
];

let router = new VueRouter({routes});

let app = new Vue({
    router
}).$mount('#app');