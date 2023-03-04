package abhi.base.beans;

import java.util.List;


public class OxfordWord {
	  
	private MetaData metadata;
	private List<Result> results;
	
	
	
	

	public MetaData getMetadata() {
		return metadata;
	}

	public void setMetadata(MetaData metadata) {
		this.metadata = metadata;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> result) {
		this.results = result;
	}

	public class MetaData {
		String provider;

		public String getProvider() {
			return provider;
		}

		public void setProvider(String provider) {
			this.provider = provider;
		}

	}

	public class Result {
		private String id;
		private String language;
		private List<LexicalEntries> lexicalEntries;
		private String type;
		private String word;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getLanguage() {
			return language;
		}

		public void setLanguage(String language) {
			this.language = language;
		}

		public List<LexicalEntries> getLexicalEntries() {
			return lexicalEntries;
		}

		public void setLexicalEntries(List<LexicalEntries> lexicalEntries) {
			this.lexicalEntries = lexicalEntries;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getWord() {
			return word;
		}

		public void setWord(String word) {
			this.word = word;
		}

		public class LexicalEntries {

			private String language;
			private List<Derivative> derivatives;
			private List<Entry> entries;
			private List<Prononciation> prononciations;
			private String lexicalCategory;
			private String text;
			
	       
			public String getLexicalCategory() {
				return lexicalCategory;
			}

			public void setLexicalCategory(String lexicalCategory) {
				this.lexicalCategory = lexicalCategory;
			}

			public String getText() {
				return text;
			}

			public void setText(String text) {
				this.text = text;
			}

			public String getLanguage() {
				return language;
			}

			public void setLanguage(String language) {
				this.language = language;
			}

			public List<Derivative> getDerivatives() {
				return derivatives;
			}

			public void setDerivatives(List<Derivative> derivatives) {
				this.derivatives = derivatives;
			}

			public List<Entry> getEntries() {
				return entries;
			}

			public void setEntries(List<Entry> entries) {
				this.entries = entries;
			}

			public List<Prononciation> getPrononciations() {
				return prononciations;
			}

			public void setPrononciations(List<Prononciation> prononciations) {
				this.prononciations = prononciations;
			}

			public class Derivative {
				String id;
				String text;

				public String getId() {
					return id;
				}

				public void setId(String id) {
					this.id = id;
				}

				public String getText() {
					return text;
				}

				public void setText(String text) {
					this.text = text;
				}

			}

			public class Entry {
				String homographNumber;
				List<String> etymologies;
				List<GramaticalFeature> grammaticalFeatures;
				List<Sense> senses;
				List<Note> notes;
				
				public List<Note> getNotes() {
					return notes;
				}

				public void setNotes(List<Note> notes) {
					this.notes = notes;
				}

				public List<Sense> getSenses() {
					return senses;
				}

				public void setSenses(List<Sense> senses) {
					this.senses = senses;
				}

				public String getHomographNumber() {
					return homographNumber;
				}

				public void setHomographNumber(String homographNumber) {
					this.homographNumber = homographNumber;
				}

				public List<String> getEtymologies() {
					return etymologies;
				}

				public void setEtymologies(List<String> etymologies) {
					this.etymologies = etymologies;
				}

			

				public List<GramaticalFeature> getGrammaticalFeatures() {
					return grammaticalFeatures;
				}

				public void setGrammaticalFeatures(List<GramaticalFeature> grammaticalFeatures) {
					this.grammaticalFeatures = grammaticalFeatures;
				}


				
				public class Note{
					 private String type;
					 private String text;
					public String getType() {
						return type;
					}
					public void setType(String type) {
						this.type = type;
					}
					public String getText() {
						return text;
					}
					public void setText(String text) {
						this.text = text;
					}
					 
					 
				}
				

				public class GramaticalFeature {
					String text;
					String type;

					public String getText() {
						return text;
					}

					public void setText(String text) {
						this.text = text;
					}

					public String getType() {
						return type;
					}

					public void setType(String type) {
						this.type = type;
					}

				}// end of class

				public class Sense {
					List<String> definitions;
					List<Example> examples;
					List<Sense> subsences;
					List<String> shortDefinitions;
					List<ThesaurusLink> thesaurusLink;
					String id;
					
					

					public String getId() {
						return id;
					}

					public void setId(String id) {
						this.id = id;
					}

					public List<String> getDefinitions() {
						return definitions;
					}

					public void setDefinitions(List<String> definitions) {
						this.definitions = definitions;
					}

					public List<Example> getExamples() {
						return examples;
					}

					public void setExamples(List<Example> examples) {
						this.examples = examples;
					}

					public List<Sense> getSubsences() {
						return subsences;
					}

					public void setSubsences(List<Sense> subsences) {
						this.subsences = subsences;
					}

					public List<String> getShortDefinitions() {
						return shortDefinitions;
					}

					public void setShortDefinitions(List<String> shortDefinitions) {
						this.shortDefinitions = shortDefinitions;
					}

					public List<ThesaurusLink> getThesaurusLink() {
						return thesaurusLink;
					}

					public void setThesaurusLink(List<ThesaurusLink> thesaurusLink) {
						this.thesaurusLink = thesaurusLink;
					}
					
					
					public class Example{
						
						String text;

						public String getText() {
							return text;
						}

						public void setText(String text) {
							this.text = text;
						}
						
						
					}
					

					public class ThesaurusLink {

						String entryId;
						String SenseId;

						public String getEntryId() {
							return entryId;
						}

						public void setEntryId(String entryId) {
							this.entryId = entryId;
						}

						public String getSenseId() {
							return SenseId;
						}

						public void setSenseId(String senseId) {
							SenseId = senseId;
						}

					}

				}

			}

			public class Prononciation {
				
				String audioFileUrl;
				String phoneticNotation;
				String phoneticSpelling;
				List<String> dialects;
				public String getAudioFileUrl() {
					return audioFileUrl;
				}
				public void setAudioFileUrl(String audioFileUrl) {
					this.audioFileUrl = audioFileUrl;
				}
				public String getPhoneticNotation() {
					return phoneticNotation;
				}
				public void setPhoneticNotation(String phoneticNotation) {
					this.phoneticNotation = phoneticNotation;
				}
				public String getPhoneticSpelling() {
					return phoneticSpelling;
				}
				public void setPhoneticSpelling(String phoneticSpelling) {
					this.phoneticSpelling = phoneticSpelling;
				}
				public List<String> getDialects() {
					return dialects;
				}
				public void setDialects(List<String> dialects) {
					this.dialects = dialects;
				}
				
				

			}

		}
	}

}
