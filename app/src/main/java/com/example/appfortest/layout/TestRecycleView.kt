package com.example.appfortest.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appfortest.R
import com.example.appfortest.adapter.MyAdapter
import com.example.appfortest.data.RecycleViewData
import kotlinx.android.synthetic.main.activity_test_recycle_view.*

class TestRecycleView : AppCompatActivity() {
    var recycleDataTest = ArrayList<RecycleViewData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_recycle_view)

        supportActionBar?.title = "Recycle view"
        //ใส่ปุ่มย้อนกลับใน action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //เรียก function เพิ่มข้อมูลลงในระบบเพื่อนำไปใช้แสดงข้อมูลใน Recycle view
        addDamyData()

        //ติดต่อหน้า adapter เพื่อนำหน้านั้นมาใส่ใน Recycle view
        TestForShowRecycleView.adapter = MyAdapter(recycleDataTest,this)
        TestForShowRecycleView.layoutManager = LinearLayoutManager(this)

    }
    //funtion ที่วน loop เก็บข้อมูล
    private fun addDamyData() {
        for (i in 1..50){
            if (i%2 != 0){
                recycleDataTest.add(RecycleViewData("Hello I'am number $i",R.drawable.image2))
            }else{
                recycleDataTest.add(RecycleViewData("I'am know but I'am number $i",R.drawable.images))
            }
        }
    }
    //ทำให้ปุ่มย้อนกลับบน action bar ทำงานได้ โดยจะย้อนกลับไปหน้าก่อนหน้านั้น
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
