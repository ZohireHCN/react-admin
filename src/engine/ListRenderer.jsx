export default function ListRenderer({ resource }) {
  const fields = resource.fields.filter(field => field.showInList);

  return (
    <table border="1" cellPadding="8" style={{ borderCollapse: 'collapse' }}>
      <thead>
        <tr>
          {fields.map(field => (
            <th key={field.name}>{field.label}</th>
          ))}
        </tr>
      </thead>

      <tbody>
        <tr>
          {fields.map(field => (
            <td key={field.name}>--</td>
          ))}
        </tr>
      </tbody>
    </table>
  );
}