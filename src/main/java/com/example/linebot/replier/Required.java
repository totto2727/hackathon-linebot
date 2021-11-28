package com.example.linebot.replier;

import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

public class Required extends Reply<MessageEvent<TextMessageContent>> {
    public Required(MessageEvent<TextMessageContent> event) {
        super(event);
        //TODO Auto-generated constructor stub
    }

    @Override
    public Message reply() {
        return new TextMessage(
                "水 3L\n食料 3日分\n衣類 3セット\nタオル 3枚\nマスク 3個\n予備電池 1本\n懐中電灯 1個\nマッチ 1箱\n救急用品 1セット\n使い捨てカイロ 3個\nブランケット 1枚\nレインウェア 1着\nズック靴 1足\n防災用ヘルメット 1個\n軍手 １個\n洗面用具 1セット\n歯ブラシ 1個\nウェットティッシュ 1個\n\nを準備しようね!\n");
    }
}