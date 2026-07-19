import CohortDetails from './Components/CohortDetails';

function App() {

  const cohorts = [
    {
      cohortCode: 'INTADMDF10',
      technology: '.NET FSD',
      startDate: '22-Feb-2022',
      currentStatus: 'Scheduled',
      coachName: 'Apoorv',
      trainerName: 'Apoorv'
    },
    {
      cohortCode: 'ADM21JF014',
      technology: 'Java FSD',
      startDate: '10-Sep-2021',
      currentStatus: 'Ongoing',
      coachName: 'Apoorv',
      trainerName: 'Apoorv'
    },
    {
      cohortCode: 'CDBJF21025',
      technology: 'Java FSD',
      startDate: '24-Dec-2021',
      currentStatus: 'Ongoing',
      coachName: 'Apoorv',
      trainerName: 'Apoorv'
    }
  ];

  return (
    <div>
      {cohorts.map((cohort, index) => (
        <CohortDetails key={index} cohort={cohort} />
      ))}
    </div>
  );
}

export default App;