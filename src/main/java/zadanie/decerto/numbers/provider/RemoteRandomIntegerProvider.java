package zadanie.decerto.numbers.provider;

import org.springframework.stereotype.Component;
import zadanie.decerto.numbers.exception.DataProviderException;
import zadanie.decerto.numbers.model.number.ProvidedInteger;
import zadanie.decerto.numbers.model.number.ProvidedData;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class RemoteRandomIntegerProvider implements DataProvider {

    @Override
    public ProvidedData provide() {
        URL url;
        try {
            url = new URL("https://www.random.org/integers/?num=1&min=1&max=10&col=1&base=10&format=plain&rnd=new");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            if (con.getResponseCode() == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                return new ProvidedInteger(Integer.valueOf(br.readLine()));
            } else throw new DataProviderException("Failed to get valid response");
        } catch (Exception e) {
            throw new DataProviderException(e);
        }
    }

}
