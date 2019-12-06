package com.example.ocrdemo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.baidu.ocr.sdk.OCR
import com.baidu.ocr.sdk.OnResultListener
import com.baidu.ocr.sdk.exception.OCRError
import com.baidu.ocr.sdk.model.AccessToken
import com.baidu.ocr.sdk.model.GeneralResult
import com.baidu.ocr.ui.camera.CameraActivity


class MainActivity : AppCompatActivity() {
    val TAG = "OCR"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        OCR.getInstance(this).initAccessToken(object : OnResultListener<AccessToken> {

            override fun onResult(result: AccessToken?) {
                // 调用成功，返回AccessToken对象
                val token = result!!.getAccessToken()
                Log.e(TAG, result.toString());
            }

            override fun onError(error: OCRError?) {
                // 调用失败，返回OCRError子类SDKError对象
                Log.e(TAG, error.toString());
            }
        }, applicationContext)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 111 && resultCode == Activity.RESULT_OK) {
            // 获取调用参数
            val contentType = data!!.getStringExtra(CameraActivity.KEY_CONTENT_TYPE)
            // 通过临时文件获取拍摄的图片
            val filePath = FileUtil.getSaveFile(applicationContext).getAbsolutePath()

            OCRManager.recognizeAccurateBasic(
                this,
                filePath,
                object : OCRManager.OCRCallBack<GeneralResult> {
                    override fun failed(error: OCRError) {
                        // 调用失败，返回OCRError对象
                        Log.e(TAG, "错误信息：" + error.message);
                    }

                    override fun succeed(data: GeneralResult) {
                        // 调用成功，返回GeneralResult对象
                        val content = OCRManager.getResult(data)
                        val bean = GsonUtil.GsonToBean(content, GeneralBean::class.java)
                        val intent = Intent(this@MainActivity,SecondActivity::class.java)
                        intent.putExtra("bean",bean)
                        startActivity(intent)
                        Log.e(TAG, content + "")
                    }
                })
        }
    }

    fun ocrClick(view: View) {
        // 生成intent对象
        val intent = Intent(this@MainActivity, CameraActivity::class.java)
        // 设置临时存储
        intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH, FileUtil.getSaveFile(getApplication()).getAbsolutePath())
        // 调用除银行卡，身份证等识别的activity
        intent.putExtra(CameraActivity.KEY_CONTENT_TYPE, CameraActivity.CONTENT_TYPE_GENERAL)
        startActivityForResult(intent, 111);
    }
}
