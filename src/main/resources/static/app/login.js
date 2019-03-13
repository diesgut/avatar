new Vue({
    el: '#formContent',
    data: {
        usuario:{userName:"",password:""}
    },
    mounted() {
       
    },
    methods: {
        logear() {
                let $vue=this;
               $.ajax({
                url: '/login',
               dataType: "json",
                            contentType: "application/json",
                            type: 'POST',
                async: true,
                data:  JSON.stringify($vue.usuario),
                success(response) {
                    if (response.success) {
                        console.dir(response);
                    } else {
                        console.dir(response);
                    }
                },
                error() {
                    
                }
            });
        }
    }
});
