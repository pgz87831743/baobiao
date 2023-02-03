<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="12" :offset="3">
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
      input3: "",
      html: ""
    }
  }
  ,
  methods: {
    search() {
      console.log(this.input3)
      // this.$http.post("tb/test2", {
      //       "ssm": "<speak xmlns=\"http://www.w3.org/2001/10/synthesis\" xmlns:mstts=\"http://www.w3.org/2001/mstts\" version=\"1.0\"xml:lang=\"en-US\"><voice name=\"zh-CN-YunyangNeural\"><mstts:express-as> <prosody rate=\"0%\" pitch=\"0%\">jsonRes </prosody>  </mstts:express-as></voice></speak>",
      //       "user": 20,
      //       "presenter": 1,
      //       "taskname": "888888",
      //       "bg": {
      //         "npy": "bgvideo/david/1.npy",
      //         "pic": "https://dataman-1310830509.cos.ap-beijing.myqcloud.com/david_1_.png",
      //         "padd": [
      //           90,
      //           10,
      //           20,
      //           80
      //         ],
      //         "path": "bgvideo/david/1.mp4",
      //         "actions": [],
      //         "needmerge": false
      //       },
      //       "dealtype": 0
      //     }
      // )

      this.$http({
        method: "post",
        url: "tb/test",
        params: {
          "item": "<speak xmlns=\"http://www.w3.org/2001/10/synthesis\" xmlns:mstts=\"http://www.w3.org/2001/mstts\" version=\"1.0\"xml:lang=\"en-US\"><voice name=\"zh-CN-YunyangNeural\"><mstts:express-as> <prosody rate=\"0%\" pitch=\"0%\">jsonRes </prosody>  </mstts:express-as></voice></speak>",
          "info": ""
        }
      })
    }
  }
}

</script>

<style scoped>
.el-row {
  margin-top: 15px;
}
</style>