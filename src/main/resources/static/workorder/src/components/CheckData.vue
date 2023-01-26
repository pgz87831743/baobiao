<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="12" :offset="6">
        <el-input placeholder="请输入内容" v-model="input3" class="input-with-select">
          <el-button slot="append" icon="el-icon-search" @click="search"></el-button>
        </el-input>
      </el-col>
    </el-row>

    <div class="tb">
      <div v-html="html" ></div>
    </div>

  </div>
</template>

<script>
export default {
  name: "CheckData",
  data() {
    return {
      input3: "",
      html: ''
    }
  }
  ,
  methods: {
    search() {

      this.$http.get(`/tb/checkData/${this.input3}`)
          .then(resp => {
            this.html = resp.data
          })
    }
  }
}

</script>

<style scoped>
.el-row {
  margin-top: 15px;
}

.tb {
  margin-top: 15px;
  margin-left: 30px;
  margin-right: 30px;
}


</style>
