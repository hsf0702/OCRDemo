package com.example.ocrdemo

import java.io.Serializable

/**
 * created by hsf
 * date:2019/12/6
 * description:
 */
class GeneralBean : Serializable {

    /**
     * log_id : 8269460345763795654
     * direction : 0
     * words_result_num : 16
     * words_result : [{"words":"姓名电话"},{"words":"朱某某88081201"},{"words":"王某某88081202"},{"words":"李某某88081203"},{"words":"张某某88081204"},{"words":"谢某某88081205"},{"words":"陈某某88081206"},{"words":"赖某某88081207"},{"words":"钟某某88081208"},{"words":"黄某某88081209"},{"words":"祝某某"},{"words":"88081210"},{"words":"范某某"},{"words":"88081211"},{"words":"林某某"},{"words":"88081212"}]
     */

    var log_id: Long = 0
    var direction: Int = 0
    var words_result_num: Int = 0
    var words_result: List<WordsResultBean> = ArrayList()

    class WordsResultBean : Serializable {
        /**
         * words : 姓名电话
         */

        var words: String = ""
    }
}
