package dev.toke.springthymehtmxstarter.data.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "HarnessRevisions")
@Getter
@Setter
@NoArgsConstructor
public class HarnessRevision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long revisionId;
    private String partNumber;
    private String revision;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double cut;
    private Double terminal;
    private Double miscellaneous;
    private Double assembly;
    private Double per;
    private LocalDateTime lastRU;
    private Double rollUp;
    private Boolean isElectricalTestBoard;
    private String productionPlan;
    private String chartVisualStorage;

    private LocalDateTime pendingDate;

    private LocalDateTime waitingDate;

    private LocalDateTime approvedDate;

    private String engineerInitials;

    private LocalDateTime removedDate;

    private String removedBy;

    private LocalDateTime returnedDate;

    private Boolean requiresLabels;

    private Boolean requiresLabelPerProduct;
    private Boolean isDoNotRelease;

    private Boolean isChanged;

    private Boolean isCurrent;

    private String notes;

    private Boolean requiresTrainingDocuments;

    private Boolean requiresStandardDocuments;

    private Boolean requiresSOPDocuments;

    private Boolean requiresCheckSheet;

    private Boolean requiresLaminatedSheet;

    private Boolean requiresVisualDocuments;

    private Boolean requiresNoteDocuments;

    private Boolean requiresSortSheetDocuments;

    private Boolean requiresBundledHarnessDocuments;

    private Boolean requiresOtherDocuments;

    private Boolean wipInspectSequence1;

    private Boolean wipInspectSequence2;

    private Boolean wipInspectSequence3;

    private Boolean wipInspectSequence4;

    private Boolean wipInspectSequence5;

    private Boolean wipInspectSequence6;

    private Boolean isUnreleased;

    private Boolean hasError;

    private Boolean isBomAvailable;

    private String insertUser;

    private String updateUser;

    private LocalDateTime insertTimestamp;

    private LocalDateTime updateTimestamp;

    private LocalDateTime lastValidated;

    private String DnrNotes;

    private Integer assemblyLevelId;

    private String wipStopNotes;

    private Integer productLabelFormatId;

    private Integer productLabelsPerBag;

    private Integer harnessesPerBundle;

    private LocalDateTime erpLastSynchRequested;

    private LocalDateTime erpLastSynchAttempted;

    private String variation;

    private LocalDateTime addedDate;

    @ManyToOne
    @JoinColumn(name = "qa_id", referencedColumnName = "id")
    private QcPlan qualityAssurance;

    public HarnessRevision(
            String partNumber,
            String revision,
            String engineerName,
            QcPlan qcPlan
    ) {
        this.partNumber = partNumber;
        this.revision = revision;
        this.engineerInitials = engineerName;
        this.startDate = LocalDateTime.now();
        this.cut = 0.0;
        this.terminal = 0.0;
        this.miscellaneous = 0.0;
        this.assembly = 0.0;
        this.per = 1.0;
        this.rollUp = 0.0;
        this.isElectricalTestBoard = true;
        this.qualityAssurance = qcPlan;
        this.productionPlan = "";
        this.chartVisualStorage = "E";
        this.pendingDate = LocalDateTime.now();
        this.waitingDate = null;
        this.approvedDate = LocalDateTime.now();
        this.removedBy = "";
        this.requiresLabels = true;
        this.requiresLabelPerProduct = true;
        this.isDoNotRelease = false;
        this.isChanged = false;
        this.isCurrent = false;
        this.notes = "";
        this.requiresTrainingDocuments = false;
        this.requiresStandardDocuments = false;
        this.requiresSOPDocuments = false;
        this.requiresLaminatedSheet = false;
        this.requiresCheckSheet = false;
        this.requiresVisualDocuments = false;
        this.requiresNoteDocuments = false;
        this.requiresSortSheetDocuments = false;
        this.requiresBundledHarnessDocuments = false;
        this.requiresOtherDocuments = false;
        this.wipInspectSequence1 = false;
        this.wipInspectSequence2 = false;
        this.wipInspectSequence3 = false;
        this.wipInspectSequence4 = false;
        this.wipInspectSequence5 = false;
        this.wipInspectSequence6 = false;
        this.isUnreleased = false;
        this.isBomAvailable = true;
        this.hasError = false;
        this.insertUser = engineerName;
        this.updateUser = engineerName;
        this.insertTimestamp = LocalDateTime.now();
        this.updateTimestamp = LocalDateTime.now();
        this.lastValidated = LocalDateTime.now();
        this.DnrNotes = "";
        this.assemblyLevelId = 1;
        this.wipStopNotes = "";
        this.productLabelFormatId = 1;
        this.productLabelsPerBag = 1;
        this.harnessesPerBundle = 1;
        this.erpLastSynchAttempted = LocalDateTime.now();
        this.erpLastSynchRequested = LocalDateTime.now();
    }
}
