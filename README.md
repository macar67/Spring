# Spring



Authentication için JWT kullanılmıştır.
Database olarak MYSQL kullanılmıştır.
Maalesef authentication nedeniyle swagger kullanamadım bu nedenle gerekli bilgileri aşağıda paylaşıyorum.
Uygulama ayapa kalkdığında gerekli tablolar ve tablo içerisindeki test verileri eklenecektir.
Tablolar ve verileri otomatik geliyor fakat eğer db yi bulamaması durumu olursa <users> adında bir db oluşturduktan sonra denerseniz verilerin geldiğini göreceksiniz
Loglama için bir end-point koydum.Gerekli yerlerde  çapırıp görebilirsiniz fakat her durum için loglama yapmadım.Gerek görmedim.Aynı işlemleri tekrarlamak istemedim.
Son olarak bazı bussiness rules ekledim Bunlar:
        *Plaka sı olmayan yeni bir araç eklenemez.
        *Rota tablosunda mevcut olmayan bir rota güzergazı bir araça assig edilemez.
        *Bir rota en az 2 durağa sahip olmalı.
Bu şekilde istenmeyen istekler atldığında gerekli uyarıcı mesajlar atılıyor.

Request adreslerini ve ayrıntılarını aşağıdan öğrenebilirsiniz.


*************** End -pointler **************************


localhost:8080/register            - POST      
localhost:8080/authenticate         - POST  

//////////////////////////////////////////////////////////////////////////////////////////
Öncelikle register 
{
        "username":"User1",
        "password":"123"
}
benzer şekilde kullanıcı oluşturmanız gerekli.
Daha sonra yine bu bilgilerle authenticate olmalısınız
{
        "username":"User1",
        "password":"123"
}
Buradan JWT  ŞEKLİNDE BİR TOKEN dönecek onu kopyalayaıp aşağıdaki her bir requestin header kısmında "Authorization" alanını karşısına "Bearer <JWT>" ŞEKLİNDE yapıştırmalısınız.
Aksi taktirde login olmuş olmayacaksınız ve 403 forbidden hatası alacaksınız.

////////////////////////////////////////
Yukarı da ki işlemleri yaptıktan sonra  bu isteleri atabilirsiniz..

localhost:8080/transport/identification    - POST 
 @RequestParam int id  ==> İD si verilen aracı döner.

localhost:8080/transport/all               - GET 
  Tüm araçları döner 

localhost:8080/transport/deleteOne         - DELETE
  @RequestParam int id verilen aracı siler

localhost:8080/transport/update            -PUT
@RequestParam int id, @RequestBody Transports )
 TRANSPORT=  { String name;
     int speed;
     int capacity;
     String plate;
     int routeid;}    
     BU bilgiler ile arac bilgilerini günceller

localhost:8080/transport/addOneVehicle     -POST
@RequestBody Transports )
Bu bilgiler ile yeni bir arç ekler
 
localhost:8080/transport/updateRoute       -PUT

RequestParam int id, @RequestBody Transports
Araca yeni bir rota ekler

localhost:8080/station/identification    -POST
@RequestParam int id bu bilgi ile id si verilen istasyon döner

localhost:8080/station/all               -GET
@Tüm istasyonları döner 

localhost:8080/station/deleteOne                 -DELETE
@RequestParam int id ==> İD VERİLEN istasyonu siler.

localhost:8080/station/update                      -PUT
@RequestParam int id, @RequestBody Stations
BU bilgiler ile istasyon bilgilreini günceller.
    STATION={ int stationid;
     String name;
     boolean isactive;}


localhost:8080/route/identification   -POST
@RequestParam int id 
id si verilen rota döner


localhost:8080/route/all               -GET
*TÜM Rotalar döner

localhost:8080/route/deleteOne            -DELETE
*@RequestParam int id
id si verilen değer silinir

localhost:8080/route/update               -PUT
@RequestParam int id, @RequestBody Route route
bu bilgiler ile güncelleme yapılır.

Route ={
     int routeid;
     String name;
     int stationnumber;
     }

localhost:8080/route/addNewRoute            -POST
@RequestBody Routestation 
BU bilgilerle Araca yeni bir rota ekler eğer uygunsa 

Routestation ={
    
        "route":{
            "routeid":7,
        "name":"route-7",
        "stationnumber":2
        },
        "stations":[{
            "stationid":4,
            "name":"adsf",
            "isactive":true

        },
        {
            "stationid":3,
            "name":"adsf",
            "isactive":true

        }
        ]
}
*BU end-point de stations json array olmalı ,route normal array olarak birlkte body içerisinde olmalılar.

localhost:8080/log/list     -GET
Tüm logları döner
