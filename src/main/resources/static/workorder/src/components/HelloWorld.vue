<template>
  <div>
    <div style="width: 50%;display: inline-block">
      <el-button type="primary"  @click="add">新增数据</el-button>
      <el-dialog title="工单信息" :visible.sync="dialogFormVisible">
        <el-form :model="item">
          <el-form-item label="工单号" :label-width="formLabelWidth">
            <el-input v-model="item.id"></el-input>
          </el-form-item>
          <el-form-item label="工单状态" :label-width="formLabelWidth">
            <el-input v-model="item.orderStatus"></el-input>
          </el-form-item>
          <el-form-item label="工单类型" :label-width="formLabelWidth">
            <el-input v-model="item.orderType"></el-input>
          </el-form-item>
          <el-form-item label="订单单号" :label-width="formLabelWidth">
            <el-input v-model="item.orderOdd"></el-input>
          </el-form-item>
          <el-form-item label="部门" :label-width="formLabelWidth">
            <el-input v-model="item.dept"></el-input>
          </el-form-item>
          <el-form-item label="性质" :label-width="formLabelWidth">
            <el-input v-model="item.nature"></el-input>
          </el-form-item>
          <el-form-item label="物料编码 " :label-width="formLabelWidth">
            <el-input v-model="item.materialCode"></el-input>
          </el-form-item>
          <el-form-item label="物料名称" :label-width="formLabelWidth">
            <el-input v-model="item.materialName"></el-input>
          </el-form-item>
          <el-form-item label="订单数量" :label-width="formLabelWidth">
            <el-input v-model="item.orderNumber"></el-input>
          </el-form-item>
          <el-form-item label="工单数量" :label-width="formLabelWidth">
            <el-input v-model="item.worderNumber"></el-input>
          </el-form-item>
          <el-form-item label="完工数量" :label-width="formLabelWidth">
            <el-input v-model="item.endNumber"></el-input>
          </el-form-item>
          <el-form-item label="下单日期" :label-width="formLabelWidth">
            <el-input v-model="item.placeData"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="saveOrUpdate()">确 定</el-button>
        </div>
      </el-dialog>

      <el-table
          :data="orderList"
          border
          style="width: 100%">
        <el-table-column prop="id" label="工单号"></el-table-column>
        <el-table-column prop="orderStatus" label="工单状态"></el-table-column>
        <el-table-column prop="orderType" label="工单类型"></el-table-column>
        <el-table-column prop="orderOdd" label="订单单号"></el-table-column>
        <el-table-column prop="dept" label="部门"></el-table-column>
        <el-table-column prop="nature" label="性质"></el-table-column>
        <el-table-column prop="materialCode" label="物料编码"></el-table-column>
        <el-table-column prop="materialName" label="物料名称"></el-table-column>
        <el-table-column prop="orderOdd" label="订单数量"></el-table-column>
        <el-table-column prop="orderNumber" label="工单数量"></el-table-column>
        <el-table-column prop="endNumber" label="完工数量"></el-table-column>
        <el-table-column prop="placeData" label="下单日期" width="180"></el-table-column>
        <el-table-column
            fixed="right"
            label="操作"
            width="100">
          <template slot-scope="scope">
            <el-button @click="del(scope.row)" type="text" size="small">删除</el-button>
            <el-button @click="upd(scope.row)" type="text" size="small">修改</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <div style="width: 50%;display: inline-block;height: 800px">
      <EcharDemo/>
    </div>
  </div>
</template>

<script>
import EcharDemo from "@/components/EcharDemo";
export default {
  components: {EcharDemo},
  methods: {
    del(row) {
      console.log(row);
      this.$http({
        params: {
          id: row.id
        },
        url: '/delete',
        method: 'get'
      }).then(res => {
        console.log(res)
        this.$message(res.data.msg);
        this.list()
      })
    },
    saveOrUpdate() {
      this.$http({
        data: this.item,
        url: '/saveOrUpdate',
        method: 'post'
      }).then(res => {
        this.$message(res.data.msg);
        this.dialogFormVisible = false
        this.list()
      })

    },
    upd(row) {
      this.item = row;
      this.dialogFormVisible = true
    },
    add() {
      this.dialogFormVisible = true
    },
    list() {
      this.$http({
        url: '/list',
        method: 'get'
      }).then(res => {
        let {data} = res.data
        this.orderList = data;
      })
    },


  },
  mounted() {
    this.list()
  },
  data() {
    return {
      orderList: [],
      dialogFormVisible: false,
      item: {
        "id": "1",
        "orderStatus": "未完成",
        "orderType": "采购",
        "orderOdd": "65535",
        "dept": "销售部",
        "nature": "普通工单",
        "materialCode": "BM001",
        "materialName": "钢筋",
        "orderNumber": 200,
        "worderNumber": 30,
        "endNumber": 25,
        "placeData": "2022-11-30 22:06:45"
      },
      formLabelWidth: '120px'

    }
  }
}
</script>