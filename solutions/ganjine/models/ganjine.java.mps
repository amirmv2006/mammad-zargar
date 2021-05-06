<?xml version="1.0" encoding="UTF-8"?>
<model ref="r:2737e1d4-065a-4187-8ffa-1e0d84d6dfe7(ganjine.java)">
  <persistence version="9" />
  <languages>
    <use id="f3061a53-9226-4cc5-a443-f952ceaf5816" name="jetbrains.mps.baseLanguage" version="11" />
    <use id="7024827d-169d-4b4c-9fcb-bfd9251096f9" name="ir.amv.laas.samples.zargari.lang" version="0" />
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
    <language id="7024827d-169d-4b4c-9fcb-bfd9251096f9" name="ir.amv.laas.samples.zargari.lang">
      <concept id="6185105629766178387" name="ir.amv.laas.samples.zargari.lang.structure.Kezelazeseze" flags="ng" index="2dFFUv" />
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
  <node concept="2dFFUv" id="5lCPy4lSCyy">
    <property role="TrG5h" value="Amir" />
  </node>
</model>

