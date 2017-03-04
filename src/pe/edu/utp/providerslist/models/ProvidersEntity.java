package pe.edu.utp.providerslist.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrador on 03/03/2017.
 */
public class ProvidersEntity extends BaseEntity {
    private static String DEFAULT_SQL = "SELECT * FROM recycle.providers";
    public List<Provider> findAll() {
        return findByCriteria(DEFAULT_SQL);
    }

    public Provider findById(int id) {
        List<Provider> providers = findByCriteria(DEFAULT_SQL + " WHERE provider_id = " + String.valueOf(id));
        return (providers != null) ? providers.get(0) : null;
    }

    public Provider findByName(String name) {
        List<Provider> providers = findByCriteria(DEFAULT_SQL + " WHERE provider_name = '" + name + "'");
        return (providers.isEmpty()) ? null : providers.get(0);
    }

    private List<Provider> findByCriteria(String sql) {
        List<Provider> providers;
        if(getConnection() != null) {
            providers = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
                while(resultSet.next()) {
                    Provider provider = new Provider(resultSet.getInt("provider_id"), resultSet.getString("provider_name"), resultSet.getString("provider_waste"), resultSet.getString("provider_process"), resultSet.getInt("provider_fullrequest"), resultSet.getInt("provider_pendrequest"));
                    providers.add(provider);
                }
                return providers;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private int getMaxId() {
        String sql = "SELECT MAX(provider_id) as max_id FROM providers";
        if(getConnection() != null) {
            try {
                ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
                return resultSet.next() ? resultSet.getInt(1) : 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public Provider create(String name, String waste, String process, int fullrequest, int pendrequest) {
        if(findByName(name) == null) {
            if(getConnection() != null) {
                String sql = "INSERT INTO providers(provider_id, provider_name, provider_waste, provider_process, provider_fullrequest. provider_pendrequest) VALUES(" +
                        String.valueOf(getMaxId()+1) + ", '" + name + "')" + ", '" + waste + "')" + ", '" + process + "')" + ", '" + fullrequest + "')" + ", '" + pendrequest + "')";
                try {
                    int results = getConnection().createStatement().executeUpdate(sql);
                    if(results > 0) {
                        Provider provider = new Provider(getMaxId(), name, waste, process, fullrequest, pendrequest);
                        return provider;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


}
