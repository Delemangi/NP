package k1.evaluatorNaKandidati;

public class BiEvaluator implements Evaluator {
    private final Evaluator a;
    private final Evaluator b;

    public BiEvaluator(Evaluator a, Evaluator b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean evaluate(Applicant app) {
        return a.evaluate(app) && b.evaluate(app);
    }
}