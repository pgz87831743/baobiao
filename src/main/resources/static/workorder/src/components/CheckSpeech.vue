<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="12"  :offset="3" >
        <el-input placeholder="请输入内容" v-model="input3" class="input-with-select">
          <el-button slot="append" icon="el-icon-search" @click="search"></el-button>
        </el-input>
      </el-col>
    </el-row>
    <div v-html="html" ></div>
    <el-button type="primary"@click="syy">上一页</el-button><el-button type="primary" @click="xyy">下一页</el-button>
  </div>
</template>

<script>
export default {
  name: "CheckSpeech",
  data() {
    return {
      input3:"",
      html:"",
      page:1
    }
  }
  ,
  methods: {
    search(){
      this.page=1;
      this.$http.get(`/tb/checkSpeech/${this.input3}/${this.page}`)
          .then(resp=>{

            if (resp.data.no===-1){
              alert(resp.data.msg)
            }else{
              this.html=resp.data
            }
          })
    },
    syy(){
      if (this.page>1){
        this.page-=1;
      }
      this.$http.get(`/tb/checkSpeech/${this.input3}/${this.page}`)
          .then(resp=>{
            if (resp.data.no===-1){
              alert(resp.data.msg)
            }else{
              this.html=resp.data
            }
          })
    },
    xyy(){
      this.page+=1;
      this.$http.get(`/tb/checkSpeech/${this.input3}/${this.page}`)
          .then(resp=>{
            if (resp.data.no===-1){
              alert(resp.data.msg)
            }else{
              this.html=resp.data
            }
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