package example.quiz;

public class Score {
    double weight = 1;
    double maxScore = 1;
    double rawScore = 0;

    public double getWeight() {
        return weight;
    }

    public double getMaxScore() {
        return maxScore;
    }

    public double getRawScore() {
        return rawScore;
    }

    public double getRawPercentage() {
        return getRawScore() / getMaxScore();
    }

    public double getPercentage() {
        return Math.round(getRawPercentage() * 1000) / 10.0;
    }

    public Score setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public Score setMaxScore(double maxScore) {
        this.maxScore = maxScore;
        return this;
    }

    public Score setRawScore(double rawScore) {
        this.rawScore = rawScore;
        return this;
    }

    @Override
    public String toString() {
        return (  "Maximum Score: " + getMaxScore() + "\n"
                + "Raw Score:     " + getRawScore() + "\n"
                + "Percentage:    " + getPercentage() + "%");
    }
}
