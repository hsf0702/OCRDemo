package com.example.ocrdemo

import android.content.Context

import com.baidu.ocr.sdk.OCR
import com.baidu.ocr.sdk.OnResultListener
import com.baidu.ocr.sdk.exception.OCRError
import com.baidu.ocr.sdk.model.BankCardParams
import com.baidu.ocr.sdk.model.BankCardResult
import com.baidu.ocr.sdk.model.GeneralBasicParams
import com.baidu.ocr.sdk.model.GeneralParams
import com.baidu.ocr.sdk.model.GeneralResult
import com.baidu.ocr.sdk.model.IDCardParams
import com.baidu.ocr.sdk.model.IDCardResult
import com.baidu.ocr.sdk.model.OcrRequestParams
import com.baidu.ocr.sdk.model.OcrResponseResult
import com.baidu.ocr.sdk.model.ResponseResult

import java.io.File

/**
 * created by hsf
 * date:2019/12/6
 * description:
 */
object OCRManager {

    /**
     * 通用文字识别接口
     * @param context   上下文
     * @param filePath  图片文件路径
     * @param ocrCallBack 请求回调
     */
    fun recognizeGeneralBasic(
        context: Context,
        filePath: String,
        ocrCallBack: OCRCallBack<GeneralResult>
    ) {
        // 通用文字识别参数设置
        val param = GeneralBasicParams()
        param.setDetectDirection(true)
        param.imageFile = File(filePath)

        // 调用通用文字识别服务
        OCR.getInstance(context)
            .recognizeGeneralBasic(param, object : OnResultListener<GeneralResult> {
                override fun onResult(result: GeneralResult) {
                    ocrCallBack.succeed(result)
                }

                override fun onError(ocrError: OCRError) {
                    ocrCallBack.failed(ocrError)
                }
            })
    }

    /**
     * 通用文字识别接口（高精度版）
     * @param context   上下文
     * @param filePath  图片文件路径
     * @param ocrCallBack 请求回调
     */
    fun recognizeAccurateBasic(
        context: Context,
        filePath: String,
        ocrCallBack: OCRCallBack<GeneralResult>
    ) {
        // 通用文字识别参数设置
        val param = GeneralBasicParams()
        param.setDetectDirection(true)
        param.imageFile = File(filePath)

        // 调用通用文字识别服务
        OCR.getInstance(context)
            .recognizeAccurateBasic(param, object : OnResultListener<GeneralResult> {
                override fun onResult(result: GeneralResult) {
                    ocrCallBack.succeed(result)
                }

                override fun onError(ocrError: OCRError) {
                    ocrCallBack.failed(ocrError)
                }
            })
    }

    /**
     * 通用文字识别接口（含位置信息版）
     * @param context   上下文
     * @param filePath  图片文件路径
     * @param ocrCallBack 请求回调
     */
    fun recognizeGeneral(
        context: Context,
        filePath: String,
        ocrCallBack: OCRCallBack<GeneralResult>
    ) {
        // 通用文字识别参数设置
        val param = GeneralParams()
        param.setDetectDirection(true)
        param.imageFile = File(filePath)

        // 调用通用文字识别服务
        OCR.getInstance(context).recognizeGeneral(param, object : OnResultListener<GeneralResult> {
            override fun onResult(result: GeneralResult) {
                ocrCallBack.succeed(result)
            }

            override fun onError(ocrError: OCRError) {
                ocrCallBack.failed(ocrError)
            }
        })
    }

    /**
     * 通用文字识别接口（高精度含位置信息版）
     * @param context   上下文
     * @param filePath  图片文件路径
     * @param ocrCallBack 请求回调
     */
    fun recognizeAccurate(
        context: Context,
        filePath: String,
        ocrCallBack: OCRCallBack<GeneralResult>
    ) {
        // 通用文字识别参数设置
        val param = GeneralParams()
        param.setDetectDirection(true)
        param.imageFile = File(filePath)

        // 调用通用文字识别服务
        OCR.getInstance(context).recognizeAccurate(param, object : OnResultListener<GeneralResult> {
            override fun onResult(result: GeneralResult) {
                ocrCallBack.succeed(result)
            }

            override fun onError(ocrError: OCRError) {
                ocrCallBack.failed(ocrError)
            }
        })
    }

    /**
     * 通用文字识别接口(含生僻字版)
     * @param context   上下文
     * @param filePath  图片文件路径
     * @param ocrCallBack 请求回调
     */
    fun recognizeGeneralEnhanced(
        context: Context,
        filePath: String,
        ocrCallBack: OCRCallBack<GeneralResult>
    ) {
        // 通用文字识别参数设置
        val param = GeneralBasicParams()
        param.setDetectDirection(true)
        param.imageFile = File(filePath)

        // 调用通用文字识别服务
        OCR.getInstance(context)
            .recognizeGeneralEnhanced(param, object : OnResultListener<GeneralResult> {
                override fun onResult(result: GeneralResult) {
                    ocrCallBack.succeed(result)
                }

                override fun onError(ocrError: OCRError) {
                    ocrCallBack.failed(ocrError)
                }
            })
    }

    /**
     * 网络图片文字识别
     * @param context   上下文
     * @param filePath  图片路径
     * @param ocrCallBack 请求回调
     */
    fun recognizeWebimage(
        context: Context,
        filePath: String,
        ocrCallBack: OCRCallBack<GeneralResult>
    ) {
        // 网络图片识别参数设置
        val param = GeneralBasicParams()
        param.setDetectDirection(true)
        param.imageFile = File(filePath)

        // 调用网络图片识别服务
        OCR.getInstance(context).recognizeWebimage(param, object : OnResultListener<GeneralResult> {
            override fun onResult(result: GeneralResult) {
                ocrCallBack.succeed(result)
            }

            override fun onError(ocrError: OCRError) {
                ocrCallBack.failed(ocrError)
            }
        })
    }

    /**
     * 银行卡识别
     * @param context   上下文
     * @param filePath  图片文件路径
     * @param ocrCallBack 请求回调
     */
    fun recognizeBankCard(
        context: Context,
        filePath: String,
        ocrCallBack: OCRCallBack<BankCardResult>
    ) {
        // 银行卡识别参数设置
        val param = BankCardParams()
        param.imageFile = File(filePath)

        // 调用银行卡识别服务
        OCR.getInstance(context)
            .recognizeBankCard(param, object : OnResultListener<BankCardResult> {
                override fun onResult(result: BankCardResult) {
                    // 调用成功，返回BankCardResult对象
                    ocrCallBack.succeed(result)
                }

                override fun onError(error: OCRError) {
                    // 调用失败，返回OCRError对象
                    ocrCallBack.failed(error)
                }
            })
    }

    /**
     * 身份证识别
     * @param context   上下文
     * @param filePath  图片文件路径
     * @param ocrCallBack 请求回调
     */
    fun recognizeIDCard(
        context: Context,
        filePath: String,
        ocrCallBack: OCRCallBack<IDCardResult>
    ) {
        // 身份证识别参数设置
        val param = IDCardParams()
        param.imageFile = File(filePath)

        // 调用身份证识别服务
        OCR.getInstance(context).recognizeIDCard(param, object : OnResultListener<IDCardResult> {
            override fun onResult(result: IDCardResult) {
                // 调用成功，返回BankCardResult对象
                ocrCallBack.succeed(result)
            }

            override fun onError(error: OCRError) {
                // 调用失败，返回OCRError对象
                ocrCallBack.failed(error)
            }
        })
    }

    /**
     * 行驶证识别
     * @param context   上下文
     * @param filePath  图片文件路径
     * @param ocrCallBack 请求回调
     */
    fun recognizeVehicleLicense(
        context: Context,
        filePath: String,
        ocrCallBack: OCRCallBack<OcrResponseResult>
    ) {
        // 行驶证识别参数设置
        val param = OcrRequestParams()
        // 设置image参数
        param.imageFile = File(filePath)
        // 设置其他参数
        param.putParam("detect_direction", true)
        // 调用行驶证识别服务
        OCR.getInstance(context)
            .recognizeVehicleLicense(param, object : OnResultListener<OcrResponseResult> {
                override fun onResult(result: OcrResponseResult) {
                    // 调用成功，返回OcrResponseResult对象
                    ocrCallBack.succeed(result)
                }

                override fun onError(error: OCRError) {
                    // 调用失败，返回OCRError对象
                    ocrCallBack.failed(error)
                }
            })
    }

    /**
     * 驾驶证识别
     * @param context   上下文
     * @param filePath  图片文件路径
     * @param ocrCallBack 请求回调
     */
    fun recognizeDrivingLicense(
        context: Context,
        filePath: String,
        ocrCallBack: OCRCallBack<OcrResponseResult>
    ) {
        // 驾驶证识别参数设置
        val param = OcrRequestParams()
        // 设置image参数
        param.imageFile = File(filePath)
        // 设置其他参数
        param.putParam("detect_direction", true)
        // 调用驾驶证识别服务
        OCR.getInstance(context)
            .recognizeDrivingLicense(param, object : OnResultListener<OcrResponseResult> {
                override fun onResult(result: OcrResponseResult) {
                    // 调用成功，返回OcrResponseResult对象
                    ocrCallBack.succeed(result)
                }

                override fun onError(error: OCRError) {
                    // 调用失败，返回OCRError对象
                    ocrCallBack.failed(error)
                }
            })
    }

    /**
     * 车牌识别
     * @param context   上下文
     * @param filePath  图片文件路径
     * @param ocrCallBack 请求回调
     */
    fun recognizeLicensePlate(
        context: Context,
        filePath: String,
        ocrCallBack: OCRCallBack<OcrResponseResult>
    ) {
        // 车牌识别参数设置
        val param = OcrRequestParams()
        // 设置image参数
        param.imageFile = File(filePath)
        // 设置其他参数
        param.putParam("detect_direction", true)
        // 调用车牌识别服务
        OCR.getInstance(context)
            .recognizeLicensePlate(param, object : OnResultListener<OcrResponseResult> {
                override fun onResult(result: OcrResponseResult) {
                    // 调用成功，返回OcrResponseResult对象
                    ocrCallBack.succeed(result)
                }

                override fun onError(error: OCRError) {
                    // 调用失败，返回OCRError对象
                    ocrCallBack.failed(error)
                }
            })
    }

    /**
     * 营业执照识别
     * @param context   上下文
     * @param filePath  图片文件路径
     * @param ocrCallBack 请求回调
     */
    fun recognizeBusinessLicense(
        context: Context,
        filePath: String,
        ocrCallBack: OCRCallBack<OcrResponseResult>
    ) {
        // 营业执照识别参数设置
        val param = OcrRequestParams()
        // 设置image参数
        param.imageFile = File(filePath)
        // 设置其他参数
        param.putParam("detect_direction", true)
        // 调用营业执照识别服务
        OCR.getInstance(context)
            .recognizeBusinessLicense(param, object : OnResultListener<OcrResponseResult> {
                override fun onResult(result: OcrResponseResult) {
                    // 调用成功，返回OcrResponseResult对象
                    ocrCallBack.succeed(result)
                }

                override fun onError(error: OCRError) {
                    // 调用失败，返回OCRError对象
                    ocrCallBack.failed(error)
                }
            })
    }

    /**
     * 通用票据识别
     * @param context   上下文
     * @param filePath  图片文件路径
     * @param ocrCallBack 请求回调
     */
    fun recognizeReceipt(
        context: Context,
        filePath: String,
        ocrCallBack: OCRCallBack<OcrResponseResult>
    ) {
        // 通用票据识别参数设置
        val param = OcrRequestParams()
        // 设置image参数
        param.imageFile = File(filePath)
        // 设置其他参数
        param.putParam("detect_direction", true)
        // 调用通用票据识别服务
        OCR.getInstance(context)
            .recognizeReceipt(param, object : OnResultListener<OcrResponseResult> {
                override fun onResult(result: OcrResponseResult) {
                    // 调用成功，返回OcrResponseResult对象
                    ocrCallBack.succeed(result)
                }

                override fun onError(error: OCRError) {
                    // 调用失败，返回OCRError对象
                    ocrCallBack.failed(error)
                }
            })
    }


    /**
     * 从返回内容中提取识别出的信息
     * @param result
     * @return
     */
    fun getResult(result: ResponseResult): String {
        return result.jsonRes
    }

    /**
     * 图片识别统一回调接口
     */
    interface OCRCallBack<T> {
        fun succeed(data: T)
        fun failed(error: OCRError)
    }
}

