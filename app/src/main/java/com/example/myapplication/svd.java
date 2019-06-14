//package com.example.myapplication;
//
//import android.media.Rating;
//import android.util.Log;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.List;
//
//import Jama.Matrix;
//import Jama.SingularValueDecomposition;
//
//public class svd {
//    private List<News> getSvd(User user) {
//        double[] doubles = calculate(getTable(), getUserRating(user), getUserRating(user)[0].length);
//        //todo: list haro pass bede besh
////        List<NewsModel> news = News.listAll(News.class);
//        List<Suggestion> suggestions = new ArrayList<>();
//        for (int i = 0; i < doubles.length; i++) {
//            Suggestion suggestion = new Suggestion(i, doubles[i], news.get(i));
//            suggestions.add(suggestion);
//        }
//        Collections.sort(suggestions, new Comparator<Suggestion>() {
//            @Override
//            public int compare(Suggestion o1, Suggestion o2) {
//                return Double.compare(o1.rate, o2.rate);
//            }
//        });
//        List<NewsModel> newsList = new ArrayList<>();
//        for (Suggestion s :
//                suggestions) {
//            newsList.add(s.news);
//        }
//        return newsList;
//    }
//
//    private double[][] getUserRating(User user) {
//        double[][] doubles = new double[1][];
//        List<Rating> ratings = Rating.listAll(Rating.class);
//        List<News> news = News.listAll(News.class);
//        for (int i = 0; i < news.size(); i++) {
//            doubles[0][i] = findUserRate(user, news.get(i), ratings, 2.5);
//        }
//        return doubles;
//    }
//
//    private double[][] getTable() {
//        List<User> users = User.listAll(User.class);
//        List<Rating> ratings = Rating.listAll(Rating.class);
//        List<News> news = News.listAll(News.class);
//        double[][] doubles = new double[users.size()][];
//        for (int j = 0; j < users.size(); j++) {
//            for (int i = 0; i < news.size(); i++) {
//                doubles[j][i] = findUserRate(users.get(j), news.get(i), ratings, 0);
//            }
//        }
//        return doubles;
//    }
//
//    private double findUserRate(User user, NewsModel news, List<Rating> ratings, double defaultValue) {
//        Rating rate = null;
//        for (Rating rating :
//                ratings) {
//            if (rating.getUser().equals(user) && rating.getNews().equals(news)) {
//                rate = rating;
//            }
//        }
//        if (rate != null)
//            return rate.getRate();
//        else
//            return defaultValue;
//    }
//
//    private double[] calculate(double[][] vals, double[][] rate, int cut) {
//        Matrix A = new Matrix(vals);
//        SingularValueDecomposition s = A.svd();
//        System.out.print("U = ");
//        Matrix U = s.getU().getMatrix(0, cut - 1, 0, cut - 1);
//        Matrix ut = U.transpose();
//        Matrix r = ut.times(U);
//        Matrix n = new Matrix(rate);
//        Matrix matrix = r.times(n.transpose()).transpose();
//        Log.e("", "*******************************");
//        matrix.print(9, 6);
//        Log.e("", "*******************************");
//        double[][] temp = matrix.getArray();
//        return temp[0];
//    }
//}
