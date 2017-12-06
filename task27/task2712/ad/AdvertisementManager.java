package com.javarush.task.task27.task2712.ad;


import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    /*
    private int timeSeconds;

    public void processVideos() throws NoVideoAvailableException
    {
        List<Advertisement> listVideos = storage.list();
        if (listVideos.isEmpty()) throw new NoVideoAvailableException();
        List<Advertisement> listVideosCopy = new ArrayList<>(listVideos);
        for (Advertisement ad : listVideosCopy){
            if (ad.getDuration() > timeSeconds) listVideos.remove(ad);
            if (ad.getHits() < 1) listVideos.remove(ad);
        }
        if (listVideos.isEmpty()) throw new NoVideoAvailableException();
        listVideos = selection(powerLists(listVideos));
        if (listVideos.isEmpty()) throw new NoVideoAvailableException();
        Collections.sort(listVideos, new Comparator<Advertisement>() {
            public int compare(Advertisement o1, Advertisement o2) {
                int rez = Long.compare(o2.getAmountPerOneDisplaying(), o1.getAmountPerOneDisplaying());
                if (rez!=0) return rez;
                else
                {
                    rez = Long.compare(o1.getAmountPerOneDisplaying()*1000 / o1.getDuration(),
                            o2.getAmountPerOneDisplaying()*1000 / o2.getDuration());
                    return rez;
                }
            }
        });
        for (Advertisement a: listVideos)
        {
            ConsoleHelper.writeMessage(a.getName() + " is displaying... " + a.getAmountPerOneDisplaying() + ", " +
                    a.getAmountPerOneDisplaying() * 1000 / a.getDuration());
            a.revalidate();
        }
    }
    private List<Advertisement> selection(List<List<Advertisement>> powerSet){
        Collections.reverse(powerSet);
        List<List<Advertisement>> resultCopy = new ArrayList<>(powerSet);
        for (List<Advertisement> ads : resultCopy){
            int totalTime = 0;
            for (Advertisement ad : ads){
                totalTime += ad.getDuration();
                if (ad.getHits() < 1) {
                    powerSet.remove(ads);
                    break;
                }
            }
            if (totalTime > timeSeconds) powerSet.remove(ads);
        }
        Collections.sort(powerSet, new Comparator<List<Advertisement>>()
        {
            @Override
            public int compare(List<Advertisement> o1, List<Advertisement> o2)
            {
                long money1 = 0;
                long money2 = 0;
                int duration1 = 0;
                int duration2 = 0;
                for (Advertisement ads : o1)
                {
                    money1+=ads.getAmountPerOneDisplaying();
                    duration1+=ads.getDuration();
                }
                for (Advertisement ads : o2)
                {
                    money2+=ads.getAmountPerOneDisplaying();
                    duration2+=ads.getDuration();
                }
                int rez = Long.compare(money2,money1);
                if (rez!=0) return rez;
                rez = Integer.compare(duration2,duration1);
                if (rez!=0) return rez;
                return Integer.compare(o1.size(), o2.size());
            }
        });
        return powerSet.get(0);
    }
    private List<List<Advertisement>> powerLists(List<Advertisement> originalSet) {
        List<List<Advertisement>> lists = new ArrayList<>();
        if (originalSet.isEmpty()) {
            lists.add(new ArrayList<Advertisement>());
            return lists;
        }
        List<Advertisement> list = new ArrayList<>(originalSet);
        Advertisement head = list.get(0);
        List<Advertisement> rest = new ArrayList<>(list.subList(1, list.size()));
        for (List<Advertisement> set : powerLists(rest)) {
            List<Advertisement> newSet = new ArrayList<>();
            newSet.add(head);
            newSet.addAll(set);
            lists.add(newSet);
            lists.add(set);
        }
        return lists;
    }
    public AdvertisementManager(int timeSeconds)
    {
        this.timeSeconds = timeSeconds;
    }      */
}