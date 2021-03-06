package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonUtils {

    public static int sendJsonBack(PrintWriter channel, Object bean){
        /**
         * @args channel , from response, channel to web page
         *        bean,      java bean,    field with data for web page
         */

        if (channel == null){
            System.out.println("Writer is none");
            return  -1;
        }
        else {
            String mapJakcson = object2Json(bean);
            channel.print(mapJakcson);

            return 0;
        }
    }
    public static String object2Json(Object bean){
        ObjectMapper mapper = new ObjectMapper();
        String mapJakcson = null;
        try {
            mapJakcson = mapper.writeValueAsString(bean);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(mapJakcson);
        return mapJakcson;

    }

    public static int returnJson(HttpServletResponse response, Object bean){
        response.setContentType("application/json;charset=utf-8");
        String mapJakcson = object2Json(bean);

        try {
            response.getWriter().print(mapJakcson);
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }

        return 0;
    }
}
