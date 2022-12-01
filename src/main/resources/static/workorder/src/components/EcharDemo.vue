<template>
  <div id="myChart" :style="{ width: '800px', height: '500px' }"></div>
</template>

<script>
export default {
  name: "EcharDemo",
  data() {
    return {
      // tbList: [["product","派单数","完成数"],["星期日",30,25],["星期一",150,125],["星期二",120,100],["星期四",90,75],["星期三",30,25],["星期五",60,50],["星期六",30,25]]
      tbList: []
    };
  },
  mounted() {
    this.drawLine();
    this.tb();
  },
  updated() {
    this.drawLine();
    this.tb();
  },
  methods: {
    drawLine() {
      // 基于准备好的dom，初始化echarts实例
      let myChart = this.$echarts.init(document.getElementById("myChart"));
      // 绘制图表
      myChart.setOption({
        legend: {},
        tooltip: {},
        dataset: {
          source: this.tbList
        },
        xAxis: {type: 'category'},
        yAxis: {},
        // Declare several bar series, each will be mapped
        // to a column of dataset.source by default.
        series: [{type: 'bar'}, {type: 'bar'}]
      });
    },
    tb() {
      this.$http({
        url: '/tb',
        method: 'get'
      }).then(res => {
        let {data} = res.data
        console.log(data)
        this.tbList = data;
        this.drawLine()
      })
    }
  },
};
</script>
