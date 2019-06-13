//package com.example.myapplication;
//
//import android.content.Context;
//import android.content.Intent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.TextView;
//
//import com.example.myapplication.Models.Passenger;
//import com.example.myapplication.Models.Ride;
//
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//
//import java.util.List;
//
//public class dataAdapter extends ArrayAdapter<news> {
//    private Context context;
//    public RideAdapter(@NotNull Context context, int resource, @NotNull List<news> objects) {
//        super(context, resource, objects);
//        this.context = context;
//    }
//
//    @NotNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NotNull ViewGroup parent) {
//        final news news= getItem(position);
//        if (convertView == null)
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_item, parent, false);
//        p = FindPassenger(ride.getPassenger_Id());
//        TextView pFname = convertView.findViewById(R.id.pFname);
//        pFname.setText(String.format("First name: %s", p.getFirstName()));
//        TextView pLname = convertView.findViewById(R.id.pLname);
//        pLname.setText(String.format("Last name: %s", p.getFirstName()));
//        TextView startPos = convertView.findViewById(R.id.startPos);
//        startPos.setText(String.format("Start Position: %s,%s", String.valueOf(ride.getStartX()), String.valueOf(ride.getStartY())));
//        TextView endPos = convertView.findViewById(R.id.endPos);
//        endPos.setText(String.format("End Position: %s,%s", String.valueOf(ride.getEndX()), String.valueOf(ride.getEndY())));
//        TextView distanceLabel = convertView.findViewById(R.id.distanceLabel);
//        distanceLabel.setText(String.valueOf(getDistance(ride)));
//        TextView costLabel = convertView.findViewById(R.id.costLabel);
//        costLabel.setText(String.valueOf(ride.getCost()));
//        Button button = convertView.findViewById(R.id.btn);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) { //Todo: findout button pressed in driver activity or not how???? dbTools.UpdateRide(ride, 1, 1); Intent intent1 = new Intent(context, RideProgressActivity.class); intent1.putExtra("FullName", String.format("%s %s", p.getFirstName(), p.getLastName())); intent1.putExtra("EndPos", String.format("%f,%f", ride.getEndX(), ride.getEndY())); intent1.putExtra("rideId", ride.getId()); DriverActivity.startNow(intent1); } }); return convertView; } private int getDistance(Ride ride) { int r = (int) Math.round((distance(ride.getStartX(), ride.getStartY(), ride.getEndX(), ride.getEndY(), 0, 0)) / 1000); return r; } public double distance(double lat1, double lat2, double lon1, double lon2, double el1, double el2) { final int R = 6371; // Radius of the earth double latDistance = Math.toRadians(lat2 - lat1); double lonDistance = Math.toRadians(lon2 - lon1); double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2); double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)); double distance = R * c * 1000; // convert to meters double height = el1 - el2; distance = Math.pow(distance, 2) + Math.pow(height, 2); return Math.sqrt(distance); } private Passenger FindPassenger(int passenger_id) { List<Passenger> passengerList = dbTools.getPassengerList(); for (Passenger p : passengerList) { if (p.getId() == passenger_id) { return p; } } return null; }}