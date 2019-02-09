package com.revature.bank.dao;

import com.jdbc.util.ConnectionFactory;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.HashMap;

/**
 * This will probably be deprecated. I think this is better probably though...
 *
 * TODO:
 *  Implement AccountTypeRepository with HASHMAP!
 *
 * @deprecated
 * @author Sanford Zheng
 *
 */

public class AccountTypeRepoWithList extends AccountTypeRepository{

    private static final Logger logger = Logger.getLogger(AccountTypeRepoWithList.class);
    private static final HashMap<Integer, String> ACCOUNT_TYPES = new HashMap<>();

    static {
        loadAccountTypes();
    }

    public static void loadAccountTypes() {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String query = "select * from bank_account_types";

            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while( rs.next() ) {
                ACCOUNT_TYPES.put(rs.getInt("account_type_id"), rs.getString("account_type"));
            }
        } catch( SQLException e ) {
            logger.error("SQLException occurred when loading account types!", e);
        }
    }

    public static void addAccountTypeWithMap(String type_name) {
        if(ACCOUNT_TYPES.containsValue(type_name)) return;
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "insert into bank_account_types(account_type) value(?)";

            PreparedStatement cs = conn.prepareStatement(sql);
            cs.setString(1, type_name);
            cs.execute();
//            conn.commit();
        } catch( SQLException e ) {
            logger.error("SQLException occurred when adding account type: " + type_name, e);
        }
        loadAccountTypes();
    }

    // Return deep copy of account types
    public static HashMap<Integer, String> getTypes(){
        loadAccountTypes();
        HashMap<Integer, String> res = new HashMap<>();

        for(Integer key: ACCOUNT_TYPES.keySet())
            res.put(key.intValue(), ACCOUNT_TYPES.get(key));

        return res;
    }

}
