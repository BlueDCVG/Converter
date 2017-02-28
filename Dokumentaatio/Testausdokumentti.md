# Testausdokumentti
Suurin riveistä joilla ei käydä on try and catchin cath osio koska errorien tuottoa ei kokeilla. 
Käsin olen testannut error popuppien ilmaantumisen. 

Tämä ei nyt varsinaisesti ole bugi ehkä enemmän ominaisuus kuin vika.
Raportoinnin formaatti valitaan ensimmäisen raportin mukaisesti.
Eli jos jokin autogeneroiduista raporteista poikkeaa ensimmäisestä (pituudeltaan) laukaisee se sarjan popuppeja erroreista.
Tämä ei ole ehkä kovin mukavaa. Ensinäkin koska tämän jälkeen koko generoitu cvs on viallinen.
Raporttia kirjoittaessa ei enää verrata että yhdiste nimet täsmää yms. eli jos vain yhdiste vaihtuu generoi se onnellisesti csv filen.
Koko softa siis toimii vain jos analysoitavat raportit ovat rinnakkain samanlaisia.
Mietin errorlogin kirjoittamista mutta en kerkeä tehdä sitä enää tälle kurssille. Omalla ajalla varmaan teen sen. 

Jostain syystä testit ajettaessa Netbeansissä synnyttää errorpopuppeja. Ehkä mutaatioista?
