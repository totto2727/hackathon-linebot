package replier;

import com.linecorp.bot.model.event.FollowEvent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@LineMessageHandler
public class Callback {
    public static final Logger log= LoggerFactory.getLogger(Callback.class);

    @EventMapping
    private Message handleFollow(FollowEvent event){
        Follow follow=new Follow(event);
        return  follow.reply();
    }
}
