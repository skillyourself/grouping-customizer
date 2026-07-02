//! Actividades de agrupación para el plugin

pub enum Activity {
    BountyHunter,
    SorceressGarden,
    MasteringMixology,
}

impl Activity {
    pub fn name(&self) -> &'static str {
        match self {
            Activity::BountyHunter => "Bounty Hunter",
            Activity::SorceressGarden => "Sorceress Garden",
            Activity::MasteringMixology => "Mastering Mixology",
        }
    }

    pub fn list() -> Vec<Activity> {
        vec![
            Activity::BountyHunter,
            Activity::SorceressGarden,
            Activity::MasteringMixology,
        ]
    }
}