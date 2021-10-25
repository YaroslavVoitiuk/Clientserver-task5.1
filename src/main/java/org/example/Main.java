package org.example;

public class Main
{
    public static void main( String[] args ) {
        Thread thread = new Client();
        Thread thread1 = new Server();
        thread.start();
        thread1.start();
        //здесь я выбрал Blocking так как в программе необходимо проводить расчеты
        // после того как клиент прислал данные и у сервера нет другой работы,
        // чтобы выполнять ее пока он ожидает данные
        //также в программе есть закомментированные блоки
        // которые сделают ее циклической и постоянно будут запрашивать данные для расчета,
        // в таком случае можно сделать non-blocking
    }
}
