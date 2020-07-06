public class TV {
    String currentChannel;
    int volume;
    String location;



    public TV() {
        currentChannel = "телевизор выключен";
        volume = 0;
        location = "на складе";
    }

    /**
     * Создает экземпляр класса Телевизор
     * @param channel начальный канал
     * @param volume громкость
     * @param location метоположение
     */
    public TV(String channel, int volume, String location) {
        currentChannel = channel;
        this.volume = volume;
        this.location = location;
    }


    public String geLocation() {
        return "Этот телевизор находится в " + location;
    }



    public void printInfo() {

        String volumeString = String.valueOf(volume);
        if (volume == 0) {
            volumeString = "звук выключен";
        }

        System.out.println("Текущий канал " + currentChannel + ", громкость: " + volumeString);

    }

}
