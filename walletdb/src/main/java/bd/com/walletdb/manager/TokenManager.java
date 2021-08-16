package bd.com.walletdb.manager;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import bd.com.walletdb.action.TokenAction;
import bd.com.walletdb.entity.TokenEntity;
import bd.com.walletdb.greendao.TokenEntityDao;


public class TokenManager {

    private static TokenManager manager = new TokenManager();

    private TokenManager() {
    }

    public static TokenManager getManager() {
        return manager;
    }    

    /**
     * token
     *
     * @param address 
     * @return token
     */
    public TokenEntity getTokenByAddress(String address) {
        if (TextUtils.isEmpty(address)) {
            return null;
        }
        TokenAction action = new TokenAction();
        List<TokenEntity> tokenEntities = action.eq(TokenEntityDao.Properties.Address, address).queryAnd();
        if (tokenEntities != null && tokenEntities.size() > 0) {
            return tokenEntities.get(0);
        }
        return null;
    }
}
