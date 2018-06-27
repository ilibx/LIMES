package org.aksw.limes.core.evaluation.evaluationDataLoader.datasets;

import org.aksw.limes.core.evaluation.evaluationDataLoader.IDataSetIO;

/**
 * Class to Select PersonNew Dataset for the evaluation.
 * Using this class you can perform a variety of functions on the selected dataset.
 * You can use the following functions like getName, getDataSetFolder, getConfigFile, getReferenceFile,
 * getSourceFile, getTargetFile, getSourceClass, getTargetClass, getEvaluationFilename etc.
 *
 * @author Cedric Richter
 *
 */

public class PersonNewDataSet extends BaseDataSet {
    /**
     * @return the NameOfDataSet
     */

    @Override
    public String getName() {
        return "PersonNew";
    }

    /**
     * @return the BaseFolder
     */
    @Override
    public String getDataSetFolder() {
        return super.getBaseFolder() + "Person1/";
    }


    /**
     * @return the ConfigFile
     */
    @Override
    public String getConfigFile() {
        return "personsNew.xml";
    }

    /**
     * @return the ReferenceFile
     */
    @Override
    public String getReferenceFile() {
        return "dataset11_dataset12_goldstandard_person.xml";
    }

    /**
     * @return the SourceFile
     */
    @Override
    public String getSourceFile() {
        return "person11.nt";
    }

    /**
     * @return the TargetFile
     */
    @Override
    public String getTargetFile() {
        return "person12.nt";
    }

    /**
     * @return the SourceClass
     */
    @Override
    public String getSourceClass() {
        return "http://www.okkam.org/ontology_person1.owl#Person";
    }

    /**
     * @return the TargetClass
     */
    @Override
    public String getTargetClass() {
        return "okkamperson2:Person";
    }

    /**
     * @return the EvaluationFileName
     */
    @Override
    public String getEvaluationFilename() {
        return "Pseudo_eval_Persons1.csv";
    }

    /**
     * @return OAEIType
     */
    @Override
    public String getOAEIType() {
        return "-Person";
    }

    /**
     * @return Resolved Paths of DataSet using OAEIDataSetIO
     */
    @Override
    public IDataSetIO getIO() {
        return new OAEIDataSetIO();
    }
}
