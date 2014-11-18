use cisis_template_db;

CREATE TABLE IF NOT EXISTS `journalentry` (
  `journal_text` text,
  `journal_date` varchar(255) DEFAULT NULL,
  `journal_weight` varchar(255) DEFAULT NULL,
  `journal_ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`journal_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;