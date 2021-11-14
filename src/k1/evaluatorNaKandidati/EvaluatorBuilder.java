package k1.evaluatorNaKandidati;

public class EvaluatorBuilder {
    public static Evaluator build(Evaluator.TYPE type) throws InvalidEvaluation {
        switch (type) {
            case NO_CRIMINAL_RECORD:
                return hasNoCriminalRecord;
            case MORE_EXPERIENCE:
                return hasMoreExperience;
            case MORE_CREDIT_SCORE:
                return hasMoreCreditScore;
            case NO_CRIMINAL_RECORD_AND_MORE_EXPERIENCE:
                return new BiEvaluator(hasNoCriminalRecord, hasMoreExperience);
            case MORE_EXPERIENCE_AND_MORE_CREDIT_SCORE:
                return new BiEvaluator(hasMoreExperience, hasMoreCreditScore);
            case NO_CRIMINAL_RECORD_AND_MORE_CREDIT_SCORE:
                return new BiEvaluator(hasNoCriminalRecord, hasMoreCreditScore);
            default:
                throw new InvalidEvaluation();
        }
    }

    private static final Evaluator hasNoCriminalRecord = x -> !x.hasCriminalRecord();
    private static final Evaluator hasMoreExperience = x -> x.getEmploymentYears() >= 10;
    private static final Evaluator hasMoreCreditScore = x -> x.getCreditScore() >= 500;
}