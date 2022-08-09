package com.zyj.alldemo.encrypt.run;

import cn.hsa.cep.cfc.EpClient;
import cn.hsaf.common.enums.EncType;
import cn.hsaf.common.enums.SignType;
import cn.hsaf.common.exception.HttpException;
import cn.hsaf.common.exception.SDKException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class EcClientTest {

    public static void main(String[] args) {
        // 请求Ec地址
        String epUrl = "https://fuwu-test.nhsa.gov.cn/ebus/ggfw_ylz/api/cfc/nationcfc/ec/ec_state";
        // 应用id
        String appId = "1ERIN3O3H00175430B0A0000FE3D4B06";

        // 应用安全key
        String appSecret = "1ERIN5D9B00475430B0A0000C210B2BE";

        // 应用私钥
        String appPrivateKey = "J366QcwO9Jxkom5n01oHo7aByf9KMvLtCU/xq4/SMa0=";
        // 平台公钥
        String appPublicKey = "BLivKhSRsYyaolxQDi5RBSeGU3eKaTcNsXuOfb1Ux2fuRAXO96bfcnfP42u4TwsYojxXU42Jd7vfPBROHuNhO8k=";

        String transType = "ec.";
        String version = "1.0.0";
        EpClient ecClient = new EpClient(epUrl, transType, appId, appSecret, appPrivateKey, appPublicKey, SignType.PLAIN.name(), EncType.SM4.name(), version);
        JSONObject paramDTO = new JSONObject();
        //梁书怀  身份证号210211197911025817  id 80000065
//        paramDTO.put("idNo", "210211197911025817");
//        paramDTO.put("idType", "01");
//        paramDTO.put("userName", "梁书怀");
//        paramDTO.put("appId", appId);
//        paramDTO.put("appUserId", "80000065");
        //张红杰   211102197310130522      900065486
        paramDTO.put("idNo", "211102197310130522");
        paramDTO.put("idType", "01");
        paramDTO.put("userName", "张红杰");
        paramDTO.put("appId", appId);
        paramDTO.put("appUserId", "900065486");
        try {
            JSONObject responseDTO = ecClient.sendRequest(paramDTO);
            System.out.println("返回:"+ JSON.toJSONString(responseDTO));
        } catch (SDKException e) {
            e.printStackTrace();
        } catch (HttpException e) {
            e.printStackTrace();
        }
    }

    public static void main2(String[] args) {
        // 请求Ec地址
        String epUrl = "https://fuwu-test.nhsa.gov.cn/ebus/fuwu/api/cfc/nationcfc/ec/ec_state";

        // 应用id
        String appId = "1DBHJRS5I01E0F34A8C00000B959FA99";

        // 应用安全key
        String appSecret = "506B64D53567C32583E08C13967D06F7";

        // 应用私钥
        String appPrivateKey = "AMhVpXXnr6vC55st1Kgq97/hiTCe045SxCw9iAxdSeab";
        // 平台公钥
        String appPublicKey = "BOhk6XdqihaM0C8xB1N51vOeUO0YBqSKIAz00MSVeUWibPYJND3YcFAJK0c5u1YjuIBAkt1lwhnVNrv2z00tUKo=";

        String transType = "ec.";
        String version = "1.0.0";
        EpClient ecClient = new EpClient(epUrl, transType, appId, appSecret, appPrivateKey, appPublicKey, SignType.PLAIN.name(), EncType.SM4.name(), version);
        JSONObject paramDTO = new JSONObject();
        paramDTO.put("idNo", "350582199711193519");
        paramDTO.put("idType", "01");
        paramDTO.put("userName", "王宝崇");
        paramDTO.put("appId", appId);
        paramDTO.put("appUserId", "9617D342B1857CF2");
        try {
            JSONObject responseDTO = ecClient.sendRequest(paramDTO);
            System.out.println("返回:"+ JSON.toJSONString(responseDTO));
        } catch (SDKException e) {
            e.printStackTrace();
        } catch (HttpException e) {
            e.printStackTrace();
        }
    }
}
