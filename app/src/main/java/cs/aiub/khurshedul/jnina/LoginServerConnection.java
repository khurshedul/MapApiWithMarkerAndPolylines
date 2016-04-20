package cs.aiub.khurshedul.jnina;

/**
 * Created by khurshedul on 4/6/2016.
 */
public class LoginServerConnection extends Thread {
   /* String serverURL;
    String userName;
    String password;
    MainActivity mainActivity;
    String serverResponse;

    public LoginServerConnection(String userName, String password, MainActivity activity) {
        this.userName = userName;
        this.password = password;
        serverURL = "https://natgeo-shemul.c9users.io/api/user";
        mainActivity = activity;
    }

    @Override
    public void run() {
        try {
            String urlParameters = "user_phone=" + userName + "&user_pass=" + password;
            byte[] postData = urlParameters.getBytes("UTF-8");
            int    postDataLength = postData.length;
            //String request = "https://natgeo-shemul.c9users.io/api/user";
            URL url = new URL(serverURL);
            HttpURLConnection conn= (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setInstanceFollowRedirects( false );
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("charset", "utf-8");
            conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));

            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.write(postData);

            serverResponse = "";
            String line;
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            while((line = br.readLine()) != null) {
                serverResponse += line;
            }

            JSONObject jsonObject = new JSONObject(serverResponse);
            String resp = jsonObject.getString("status");

           /* if(resp.equals("success")) {
                mainActivity.gotoMap();
            }
            else {
                mainActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(mainActivity, "Login Failed!", Toast.LENGTH_SHORT).show();
                    }
                });
            }

        } catch (Exception ex) {

        }
    }*/
}