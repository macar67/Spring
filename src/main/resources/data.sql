 INSERT INTO route (name,stationnumber) VALUES
    ( 'route-1', '2'),
    ( 'route-2', '2'),
    ( 'route-3', '3'),
    ( 'route-4', '3'),
    ( 'route-5', '2'),
    ( 'route-6', '2');



  INSERT INTO transports (name, speed,capacity,plate,routeid) VALUES
    ( 'arac-1', '50', '50','67BJK67','2'),
    ( 'arac-2', '125', '250','06ZNG67','1'),
    ( 'arac-3', '100', '18','67TRB132','3'),
    ( 'arac-4', '135', '17','78KRB67','6'),
    ( 'arac-5', '175', '30','78K67','5'),
    ( 'arac-6', '200', '98','98KMB67','4');

 INSERT INTO stations (name,isactive) VALUES
    ( 'Ulus', true),
    ( 'MilliKütüphane', true),
    ( 'Koru', true),
    ( 'Yenimahalle', true),
    ( 'Dikimevi', true),
    ( 'Batikent', true),
    ( 'Yapracik', true),
    ( 'ÜmitKöy', true),
    ( 'Kizilay', true),
    ( 'Asti', true),
    ( 'Odtü', true),
    ( 'Bilkent', true);

INSERT INTO routestationmap (route,station) VALUES
    ( '1', '2'),
    ( '1', '3'),
    ( '2', '7'),
    ( '2', '8'),
    ( '2', '1'),
    ( '3', '5'),
    ( '3', '9'),
    ( '3', '4'),
    ( '4', '12'),
    ( '4', '10'),
    ( '4', '11');