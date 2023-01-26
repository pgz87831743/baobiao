<template>
  <div>
    <el-row :gutter="20">
     <el-col :span="12"  :offset="3" >
       <el-input placeholder="请输入内容" v-model="input3" class="input-with-select">
         <el-button slot="append" icon="el-icon-search" @click="search"></el-button>
       </el-input>
     </el-col>
    </el-row>
    <div v-html="html"></div>
  </div>
</template>

<script>
export default {
  name: "CardSwiping",
  data() {
    return {
      input3:"",
      html:""
    }
  }
  ,
  methods: {
    search(){
      console.log(this.input3)
      this.$http.get(`/tb/search/${this.input3}`)
          .then(resp=>{
            this.html=resp.data
          })
    }
  }
}

</script>

<style scoped>
.el-row{
  margin-top: 15px;
}
</style>