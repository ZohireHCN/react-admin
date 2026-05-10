import { Link } from 'react-router-dom';

export default function MenuRenderer({ menu }) {
  return (
    <nav>
      {menu.map(item => (
        <div key={item.path} style={{ marginBottom: 12 }}>
          <Link to={item.path}>{item.label}</Link>
        </div>
      ))}
    </nav>
  );
}