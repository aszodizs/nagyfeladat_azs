# nagyfeladat_azs
Készíts egy Java konzol alkalmazást, ami egy webshop kedvezménykezelését szimulálja. 
Az alábbi kedvezmény típusok léteznek:

* 2=3: kettőt fizet, hármat kap. Ha a kosárban van legalább 3 egyforma termék, akkor 3
termékenként 1 termék árát kedvezményként jóvá kell írni.

* megapack ­6000: vannak nagy kiszerelésű, megapack típusú termékek. Ha ilyen termékből
egy teljes kartonnal (12 db) vásárol, akkor 6000 Ft kedvezményt kap kartononként.

A kedvezménytípusok nem összevonhatóak, mindig a legnagyobb kedvezményt nyújtót kell
figyelembe venni az egész kosárra. Egy kedvezménytípus ugyanakkor több kedvezményt is
nyújthat. Pl. ha vesz 7 gumicsirkét és 4 téliszalámit, akkor 2 gumicsirke és 1 téliszalámi
értéke a kedvezmény a 2=3 kedvezménytípus esetén. Hasonlóan, ha megapack uborkából
vesz 12­őt, megapack gesztenyéből pedig 24­et, akkor 3­szor 6000 Ft a kedvezmény a
megapack ­6000 kedvezménytípus esetén. A kedvezénytípusok könnyen bővíthetőek
legyenek.
A terméklista fix, az alábbi termékek léteznek (a kódban legyen beégetve):
* név: téliszalámi, ár: 2000, megapack: nem
* név: gumikacsa, ár: 3000, megapack: nem
* név: megapack uborka, ár: 2800, megapack: igen
* név: megapack gesztenye, ár: 1000, megapack: igen


Az alkalmazás kérje be a konzolon termékenként a termékek darabszámát. A válaszban
jelenítse meg az eredeti bekért adatokat a megadott darabszámokkal, ez alá írja ki a kosár eredeti
árát, kedvezményes árát és a kedvezmény típus nevét
