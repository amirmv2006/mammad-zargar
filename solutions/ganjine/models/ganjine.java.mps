<?xml version="1.0" encoding="UTF-8"?>
<model ref="r:2737e1d4-065a-4187-8ffa-1e0d84d6dfe7(ganjine.java)">
  <persistence version="9" />
  <languages>
    <use id="f3061a53-9226-4cc5-a443-f952ceaf5816" name="jetbrains.mps.baseLanguage" version="11" />
    <use id="b18e5995-c6de-499b-a97e-b04eeba9dfa1" name="ir.amv.laas.samples.zargari.lang" version="-1" />
  </languages>
  <imports />
  <registry>
    <language id="f3061a53-9226-4cc5-a443-f952ceaf5816" name="jetbrains.mps.baseLanguage">
      <concept id="1465982738277781862" name="jetbrains.mps.baseLanguage.structure.PlaceholderMember" flags="nn" index="2tJIrI" />
      <concept id="1068390468198" name="jetbrains.mps.baseLanguage.structure.ClassConcept" flags="ig" index="312cEu" />
      <concept id="1107461130800" name="jetbrains.mps.baseLanguage.structure.Classifier" flags="ng" index="3pOWGL">
        <child id="5375687026011219971" name="member" index="jymVt" unordered="true" />
      </concept>
      <concept id="1178549954367" name="jetbrains.mps.baseLanguage.structure.IVisible" flags="ng" index="1B3ioH">
        <child id="1178549979242" name="visibility" index="1B3o_S" />
      </concept>
      <concept id="1146644602865" name="jetbrains.mps.baseLanguage.structure.PublicVisibility" flags="nn" index="3Tm1VV" />
    </language>
    <language id="b18e5995-c6de-499b-a97e-b04eeba9dfa1" name="ir.amv.laas.samples.zargari.lang">
      <concept id="2392387871137097317" name="ir.amv.laas.samples.zargari.lang.structure.Kezelazeseze" flags="ng" index="399LTM" />
    </language>
    <language id="ceab5195-25ea-4f22-9b92-103b95ca8c0c" name="jetbrains.mps.lang.core">
      <concept id="1169194658468" name="jetbrains.mps.lang.core.structure.INamedConcept" flags="ng" index="TrEIO">
        <property id="1169194664001" name="name" index="TrG5h" />
      </concept>
    </language>
  </registry>
  <node concept="312cEu" id="3mlM5zxTC0E">
    <property role="TrG5h" value="Amir" />
    <node concept="2tJIrI" id="3mlM5zxTC0I" role="jymVt" />
    <node concept="3Tm1VV" id="3mlM5zxTC0F" role="1B3o_S" />
  </node>
  <node concept="399LTM" id="35o1wtOXIcO">
    <property role="TrG5h" value="Amir" />
  </node>
</model>

