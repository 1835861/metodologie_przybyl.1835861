package it.uniroma1.fabbricasemantica.data;

public enum StandardTask implements Task {
	TRANSLATION_ANNOTATION,
	WORD_ANNOTATION,
	DEFINITION_ANNOTATION,
	SENSE_ANNOTATION,
	TRANSLATION_VALIDATION,
	SENSE_VALIDATION,
	MYANNOTATION;
	
	private String taskId;
	
	StandardTask() {
		taskId = this.toString();
	}
	
	@Override
	public String getTaskID() {
		return taskId;
	}
	
}
