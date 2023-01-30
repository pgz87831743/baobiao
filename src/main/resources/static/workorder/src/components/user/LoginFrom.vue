<template>
  <div>
    <form action="/login" method="post">
      <input type="text" name="username" id="username">
      <input type="text" name="password" id="password">
      <button type="submit">登录</button>
    </form>
  </div>
</template>

<script>
export default {
  name: "LoginFrom",
  data() {
    return {
      form: {
        username: "",
        password: ""
      }
    }
  }
  ,
  methods: {
    submitForm() {
      this.$http.post("/login", this.form)
          .then(resp => {
            console.log(resp)
          })
    }
  }
}

</script>

<style scoped>

</style>