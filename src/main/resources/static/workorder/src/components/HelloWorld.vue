<template>
  <div>
    <el-menu
        :router="true"
        :default-active="this.$router.path"
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b">
      <el-menu-item index="CardSwiping">查贴吧</el-menu-item>
      <el-menu-item index="CheckData">查资料</el-menu-item>
      <el-menu-item index="CheckSpeech">查发言</el-menu-item>
    </el-menu>
    <KeepAlive>
      <router-view></router-view>
    </KeepAlive>
  </div>
</template>
<script>



export default {
  components: {},
  data() {
    return {
      activeIndex: '1'
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>

<style scoped>
.my{
  margin-right: 0;
}

</style>