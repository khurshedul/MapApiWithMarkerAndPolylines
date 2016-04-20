
package cs.aiub.khurshedul.jnina;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {


    double longit,lat;
    LatLng p1=null;
    String a;
    public static String USER_QUERY_LATITUDE_KEY = "LAT_KEY";
    public static String USER_QUERY_LONGTITUDE_KEY = "LONG_KEY";
    LocationManager manager ;




    private GoogleMap mMap;
    private boolean positionSet;
    private  boolean queryPostionSet;
    LatLng loc;
    Button b1;
    EditText text;

    public MapsActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
       // setContentView(R.layout.activity_custom_sni);
        b1=(Button)findViewById(R.id.setmark);
        text=(EditText)findViewById(R.id.TEXT);


        manager= (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
        positionSet = false;
      /*  y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MapsActivity.this, "yes clicked", Toast.LENGTH_SHORT).show();
            }
        });
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MapsActivity.this, "No clicked", Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    protected void onResume() {
        super.onResume();
        positionSet = false;
        queryPostionSet = false;
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    /*public LatLng getLocationFromAddress(Context context,String strAddress) {

        Geocoder coder = new Geocoder(context);
        List<Address> address;
       // LatLng p1 = null;

        try {
            address = coder.getFromLocationName(strAddress, 5);
            if (address == null) {
                return null;
            }
            Address location = address.get(0);
            location.getLatitude();
            location.getLongitude();

            p1 = new LatLng(location.getLatitude(), location.getLongitude() );

        } catch(IOException ioEx){
            return null;
        }

        return p1;
    }*/
    @Override
    public void onMapReady(GoogleMap googleMap) {
        if (manager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            mMap = googleMap;
            mMap.setMyLocationEnabled(true);
            final double[][] a={};


            Polyline line = mMap.addPolyline(new PolylineOptions()
                    .add(/*23.8325366, 90.4167793), new LatLng(23.8357360, 90.4162643)*/new LatLng(23.802036, 90.380052), new LatLng(23.802001, 90.380068), new LatLng(23.803252, 90.378596), new LatLng(23.804923, 90.379608), new LatLng(23.804049, 90.382933), new LatLng(23.803979, 90.383885))
                            //.add(new LatLng(a[i][0],a[i][1]),new LatLng(a[i+1][0],a[i+1][1]))
                    .width(3)
                    .color(Color.BLUE)
                    .geodesic(true));

            mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
                @Override
                public void onMyLocationChange(Location location) {
                    if (!positionSet) {
                        loc = new LatLng(location.getLatitude(), location.getLongitude());
                      //  loc=new LatLng(23.8048207, 90.38003449999997);
                        longit = location.getLongitude();
                        lat = location.getLatitude();

                        if (mMap != null) {
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(loc, 17));
                        }

                        positionSet = true;
                    }
                }
            });

      /* mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
           @Override
           public void onMapClick(LatLng latLng) {
               if (mMap != null) {
                   mMap.clear();
                   mMap.addMarker(new MarkerOptions().position(latLng));
                   //  UserQueryPosition = latLng;

                   queryPostionSet = true;
               }
           }
       });*/
            b1.setOnClickListener(new View.OnClickListener() {
                Marker mar = null;
                // a=text.getText().toString();
                @Override
                public void onClick(View v) {
                    if (mar != null) {
                        mar.remove();
                        mar = mMap.addMarker(new MarkerOptions().position(loc).title("custom msg").snippet(text.getText().toString() + " latitude: " + lat + " longitude: " + longit));
                    } else
                        mar = mMap.addMarker(new MarkerOptions().position(loc).title("custom msg").snippet(text.getText().toString() + " latitude: " + lat + " longitude: " + longit));


                }
            });
            mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {
                    // lstLatLngs.add(latLng);
                    Marker mar = null;
                    mMap.clear();
                    mar = mMap.addMarker(new MarkerOptions().position(latLng));
                    mar.showInfoWindow();


                }
            });
           mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
                @Override
                public View getInfoWindow(Marker marker) {
                    return null;
                }

                @Override
                public View getInfoContents(Marker marker) {
                    View myContentView = getLayoutInflater().inflate(
                            R.layout.activity_custom_sni, null);
                  /*  TextView tvTitle = ((TextView) myContentView
                            .findViewById(R.id.txv));*/
                   // tvTitle.setText(marker.getTitle());
                  TextView tvSnippet = ((TextView) myContentView
                            .findViewById(R.id.txv));
                    tvSnippet.setText("bhbjkjhkjb jhbhjb jhbhjbjhb jknkjn ");
                    Button y=((Button)myContentView.findViewById(R.id.yesbtn));
                    Button n=((Button)myContentView.findViewById(R.id.nobtn));
                    y.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(MapsActivity.this, "yes clicked", Toast.LENGTH_SHORT).show();
                        }
                    });
                    n.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(MapsActivity.this, "no clicked", Toast.LENGTH_SHORT).show();
                        }
                    });
                    return myContentView;
                }
            });


        }else{
            showGPSDisabledAlertToUser();
        }

      /*  // Add a marker in Sydney and move the camera
       LatLng sydney = new LatLng(23.7877400,90.3529500);

       // mMap.setMyLocationEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 13));

        mMap.addMarker(new MarkerOptions().position(sydney).title("Home sweet home ").snippet("Ami prioty ekhane amar bari ami ekta magi :v  "));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/
    }
    private void showGPSDisabledAlertToUser(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("GPS is disabled in your device. Would you like to enable it?")
                .setCancelable(false)
                .setPositiveButton("Goto Settings Page To Enable GPS",
                        new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){
                                Intent callGPSSettingIntent = new Intent(
                                        android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                startActivity(callGPSSettingIntent);
                            }
                        });
        alertDialogBuilder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        dialog.cancel();
                    }
                });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

}
