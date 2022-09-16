package br.com.moisesestevao.api.mensagens.application.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
@Slf4j
public class SpamService {
    private static final Map<String, Date> remoteAddrMap = new HashMap<String, Date>();
    public Boolean validate(HttpServletRequest request){
        String remoteAddr = request.getRemoteAddr();
        log.info("receiving request from ip: "+remoteAddr);

        if(remoteAddrMap.containsKey(remoteAddr)){
            Date expirationDate = (Date) remoteAddrMap.get(remoteAddr);

            if(expirationDate.getTime() > new Date().getTime()) return false;
            remoteAddrMap.remove(remoteAddr);
        }
        remoteAddrMap.put(remoteAddr, new Date(new Date().getTime() + 10000));

        return true;
    }
}



