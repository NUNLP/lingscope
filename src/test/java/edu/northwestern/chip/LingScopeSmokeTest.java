package edu.northwestern.chip;

import org.junit.Test;

/**
 * Created by eng148 on 7/22/2016.
 * https://sourceforge.net/p/lingscope/wiki/detailed_instructions/
 *
 */
public class LingScopeSmokeTest {

    @Test
    public void NegExTest() {

//        String[] args =
//        edu.northwestern.chip.lingscope.drivers.NegexDriver.main();

        assert true;
    }

    @Test
    public void SentenceTaggerTest() {

        /**
         * Word-based models:
         * crf_scope_words_all_both.model
         * crf_scope_words_all_clinical.model
         * baseline_cue_all_both.model
         * baseline_cue_all_clinical.model
         *
         * args[0] = "cue" or "scope"
         * args[1] = "crf" or "baseline"
         * args[2] = "both" models trained on both clinical and biomedical text, "cue" vs. "scope" models
         * args[3] = sentence to tag in quotes
         */

        String[] args = {"scope", "crf", "negation_models/crf_scope_words_all_both.model", "There was no sign of disease."};
        edu.northwestern.chip.lingscope.drivers.SentenceTagger.main(args);
    }

    @Test
    public void SentencePOSTagger() {

        /**
         * POS-based models:
         * f1) crf_scope_cue_crf_all_both.model
         * f2) crf_scope_cue_crf_all_clinical.model
         * f3) crf_scope_words_crf_all_both.model
         * f4) crf_scope_words_crf_all_clinical.model
         *
         * args[0] = any cue detection model file
         * args[1] = crf, baseline, or negex
         * args[2] = whether detected cue phrase should be replaced by custom tag "cue" or not, "true" for f1/f2, "false" for f3/f4
         * args[3] = any negation scope model file (cue for f1/f2, word for f3/f4)
         * args[4] = POS tagger
         * args[5] = sentence to tag in quotes
         * args[5] alternative = "file", "/path/to/sentence/file.txt" (will loop through all sentences in the file)
         */

        String[] args = {"negation_models/crf_cue_all_both.model", "crf", "true", "negation_models/crf_scope_cue_crf_all_both.model",
                            "left3words-wsj-0-18.tagger", "file", "data/Annotations-1-120-random.txt"};
        edu.northwestern.chip.lingscope.drivers.SentencePosTagger.main(args);
    }
}
