● import si.triglav.bp.properties.OsebniDokument;                                                                                              import si.triglav.bp.generated.mappers.PropertyMapperFactory;
  import si.triglav.common.vao.bp.PCharacteristicVAO;                                                                                          import si.triglav.common.vao.bp.PersonPropertyVAO;
  import java.util.List;                                                                                                                     
  // --- Reading from VAO ---
  PersonPropertyVAO personPropertyVAO = ...;  // from database
  List<PCharacteristicVAO> characteristics = personPropertyVAO.getPCharacteristicList();

  OsebniDokument dokument = PropertyMapperFactory.fromList(OsebniDokument.class, characteristics);

  // Access fields with type-safe getters
  String stevilka = dokument.getStevilkaDokumenta();
  Integer vrsta = dokument.getVrstaDokumenta();
  SimpleDate izdaja = dokument.getDatumIzdaje();
  SimpleDate konec = dokument.getKonecVeljavnosti();


  // --- Creating new document ---
  OsebniDokument novDokument = new OsebniDokument();
  novDokument.setStevilkaDokumenta("AB123456");
  novDokument.setVrstaDokumenta(1);
  novDokument.setDatumIzdaje(SimpleDate.today());
  novDokument.setKonecVeljavnosti(new SimpleDate(2030, 12, 31));

  // Convert back to characteristics for saving
  List<PCharacteristicVAO> newCharacteristics = PropertyMapperFactory.toList(novDokument, idPersProperty);